I checked the JSON structure and the values. It is syntactically valid, but several data issues would likely fail validation, so I’d fix those before sending. I’ve still generated the POJO, because the structure is consistent and the issues are value-level, not shape-level.

Issues to fix

Count mismatch: relationCount is 1, but relatedParties has 4 entries. It should match the list size. Also confirm that beneficialOwnerCount: 1 is right.
Unresolved placeholders: {{panB64}}, {{gstinB64}}, {{coiB64}} and the other {{...}} values must be replaced with real base64 before sending. The "Others - {RelationName}" relation type is also an unresolved placeholder.
Invalid DIN: directorIdentifyNumber: "40". A DIN is 8 digits.
Karta for a company: A Karta relation belongs to an HUF, not a Pvt Ltd. It also has an empty percentOfOwnership.
Ownership percentages: Promoter 60% plus Others 100% comes to 160%. Promoter and Others also reuse the same ckycId (13065788094545).
PAN and GSTIN mismatch: The GSTIN 27ABCDE1234F1Z5 embeds PAN ABCDE1234F, but your PAN is ABCCT1234Z. Characters 3-12 of a GSTIN must equal the PAN.
Invalid DIGIPIN: 4FK-Q22-K5J7 contains Q, which is not in the DIGIPIN character set (2-9, C, F, J, K, L, M, P, T).
Empty DIGI_SIGN: If the destination requires a signature, it must be populated.
Minor:
isRegisteredFirm: true for a company is odd. Check it against the spec.
The PAN’s 5th character (T) normally matches the first letter of the entity name (A for Acme). This only matters if you validate it.
The odd key dataFor_encryptedData is mapped as-is in the POJO.
TXN_SUB_TYPE: CREATE alongside the ckycInq node name looks inconsistent. Confirm it against the CERSAI spec.

I don’t have the CERSAI spec, so I couldn’t check mandatory fields or enum values such as constitutionType: "D" and the district code 443.

CkycLegalRequest.java has the POJO as one file with static nested classes, using Lombok and Jackson annotations. It maps the root envelope through to attestationDetails, and the odd dataFor_encryptedData key is mapped with @JsonProperty.

Nulls: Null values are serialized, since your JSON has explicit nulls such as line3. If CERSAI doesn’t need them, add @JsonInclude(JsonInclude.Include.NON_NULL).
Boolean fields: The isListedCompany, isRegisteredFirm and isRegisteredTrust fields use explicit @JsonProperty so Lombok’s is getter naming can’t change the JSON key.
Dates: Dates are kept as String in dd-MM-yyyy format to match your payload.

Once you fix the issues above, share the CERSAI spec if you want me to add bean-validation annotations such as @NotBlank, @Pattern for PAN, GSTIN, CIN and DIN, and @Size.

Ckyclegalrequest
Code·JAVA 

Yes. “Non-individual” is the legal-entity flow, using the corrected legal JSON from the start of this chat. I’ll reuse the client, async config and document conversion, and add a legal DTO, validator, session-document mapper and orchestration.

The test caught a real mapper bug: when a list holds several files with no names, they all got the same generated name and the duplicate check fired. I’ll make generated names unique.

I’ve built the non-individual (legal entity) version from the legal JSON you shared at the start. It reuses CersaiApiClient, CersaiAsyncConfig and the document conversion from the individual flow. I compiled and ran everything except the DAO change files.

New and changed files
CersaiLegalData.java is the DTO for the legal data. Its field names equal the JSON keys, so Gson needs no annotations. It has searchKey for Create and ckycNumber for Update. Document fields reuse CersaiRequest.DocumentFile.
CkycLegalValidator.java is the validator, with field-path error messages.
CersaiLegalDocumentMapper.java maps session documents into the DTO. Each session value can be one document or a list. Keys are:
PAN
GSTIN
ID_<documentType>, for example ID_CERTIFICATE_OF_INCORPORATION
POA_REGISTERED
POA_PRINCIPAL
DECLARATION
UNDERTAKING
The ID_ keys are dynamic: each one becomes an identity document with that documentType, so you can upload any number of types. When the principal address is the same as the registered one, the mapper copies the registered proof and file, as in your sample JSON.
CreateApiDaoImpl_legal_changes.java is the orchestration and controller guide. It extracts a shared dispatchToCersai(...) so individual and legal flows use the same background send.
CersaiDocumentMapper.java and CkycDataValidator.java are updated, with two fixes:
The test showed that several unnamed files in one list all got the same generated name. Generated names are now made unique.
An unresolved {{placeholder}} in a document now gives a clear error instead of “not valid base64”.
What the legal validator checks
Create vs update: searchKey for Create, a 14-digit ckycNumber for Update.
Entity name and registration: name format and length, mandatory flags, and registration date.
PAN: entity PAN format (the 4th character must be a non-individual type), plus verification.
GSTIN: format and state code, and that the PAN inside it equals panDetails.number.
CIN and LLPIN: CIN format, an L/U prefix consistent with isListedCompany, and the year in the CIN matching the registration year.
Identity documents and addresses: at least one valid document, address rules, and DIGIPIN format.
Contacts: a valid primary contact.
Related parties:
relationCount equals the list size.
A Director must have an 8-digit DIN.
Ownership percentages are valid, and the total of distinct persons is at most 100%.
Placeholders: unresolved values like {RelationName} are rejected.
Attestation: employee and date checks.

I ran it against your original JSON, and it flagged the problems I mentioned at the start:

the PAN and GSTIN mismatch
the DIGIPIN containing Q
relationCount 1 versus 4 parties
DIN "40"
the placeholders ({{poaSupportingDocB64}} and {RelationName})
the same CKYC ID reported with 60% and 100%

With corrected values, the same data passes as a valid Create. With no ckycNumber, the Update check fails with a clear message.

What I still need from you
Your non-individual beans and the map function. I haven’t seen them, so mapLegal(...) and buildEnvelope(...) in the changes file are marked TODO. Send me the bean classes and I’ll write the mapper, including the DB query for the legal additional details.
The constitution type codes. Your sample uses "D" and I don’t know the code list, so the validator only checks that it is present. A Karta is only valid for an HUF, so with the codes I can add that check.
The same [CONFIRM] constants as before. These are the 350 KB document limit, the 55-character address lines, the entity-name length, and the file types. They are my reading of the CKYC guidelines, not your spec.
How you tell individual from non-individual in the controller, so the final if in the controller block can be wired up.
Ckyclegalvalidator
Code·JAVA 
Cersailegaldata
Code·JAVA 
Cersailegaldocumentmapper
Code·JAVA 
Createapidaoimpl legal changes
Code·JAVA 
Cersaidocumentmapper
Code·JAVA 
Ckycdatavalidator
Code·JAVA 

i have confusion as per request i want to send just one at a time either ckyc number or search key so why we take both on the bean

Explaining why the bean holds two alternate identifier fields.

It’s a good question. The bean has both fields only so one class can serve Create and Update. Only one of them is ever sent, and the code was already meant to ensure that. I’ll tighten the validator so it enforces it.

You only ever send one of them. The bean has both fields so a single class can serve Create and Update.

How only one is sent
Create: searchKey is set and ckycNumber is null.
Update: ckycNumber is set and searchKey is null.
java
if (isUpdate) { data.setCkycNumber(ckycNum.trim()); data.setSearchKey(null); }
else          { data.setCkycNumber(null); }

Gson skips null fields by default, so the JSON contains only the one key. Update therefore has "ckycNumber": "..." and no searchKey, and Create is the reverse.

This only holds while you use new GsonBuilder().disableHtmlEscaping().create(), as in your code. If anyone adds .serializeNulls(), or you switch to Jackson without @JsonInclude(NON_NULL), you would send "searchKey": null. Keep that in mind if the spec ever needs explicit nulls elsewhere in the payload.

What I changed

Before, the validator only checked that the needed field was present. It did not reject the other one. Both validators now enforce exactly one:

Update: ckycNumber is required (14 digits), and sending searchKey is an error.
Create: searchKey is required, and sending ckycNumber is an error.

I re-ran the tests. Update with both fields set now fails with a clear message, and Update with only ckycNumber passes. The updated CkycDataValidator.java and CkycLegalValidator.java are in the same folder as before.

If you want one field instead

Using one field with a dynamic JSON key means a custom Gson serializer, which adds more risk than the two nullable fields. If you want two classes instead, I can make a CreateData and an UpdateData, each with its own field. That means the mapper, validator and orchestration each handle two types, so I’d keep the two nullable fields.

my indivsual and non inidvisaul flow is diffrent totally there are 2 diffrent menthods where i need to call

Understood. If the two flows are called from different places, they shouldn’t be wired together with an if. Each flow gets its own entry method and call site. I’ll move the shared plumbing into one small bean, so neither DAO duplicates it and each keeps its own status-saving method.

I’ve made the two flows fully independent, each with its own method and call site and no if (individual) check anywhere. I replaced the old combined guides with IndividualFlow_changes.java and NonIndividualFlow_changes.java.

Individual flow
It lives in CreateApiDaoImpl, in its own method validateAndSubmitToCersai(...).
The existing create/update if in the controller is replaced by a single call. ckycNum is passed in, and the method decides Create or Update.
It uses its own validator, CkycDataValidator, and its own document mapper, CersaiDocumentMapper.
Non-individual flow
It lives in whichever DAO or service your non-individual flow already uses, in its own method validateAndSubmitLegalToCersai(...).
It uses CkycLegalValidator and CersaiLegalDocumentMapper, with the different session keys (ID_<documentType>, POA_REGISTERED and so on).
It has its own session attribute name and its own URLs, NON_IND_CREATE_URL and NON_IND_UPDATE_URL.
What the flows share

The shared pieces are stateless beans and share no state:

CersaiApiClient, which does the encryption, HTTP call and decryption
the cersaiExecutor thread pool
the new CersaiSubmitter, which sends in the background and records the outcome

Before, the “send in the background” and “record the result” code sat in CreateApiDaoImpl, so the non-individual DAO would have needed a copy or a dependency on it. CersaiSubmitter holds it once.

Each flow gives CersaiSubmitter its own StatusRecorder, a one-line lambda calling that flow’s own updateCersaiRejectionRemark(...). If the non-individual flow saves to a different method or table, you change only that line in its file. Neither flow can break the other.

Testing

I compiled CersaiSubmitter against stubs and ran five cases:

success
a 2xx response with no acknowledgement
an HTTP failure
an exception inside the client
a full queue

Each recorded the right status: CP then CS, or CP then CF with a clear reason.

The two flow files themselves are not compiled, because they use your beans.

Still needed for the non-individual flow

mapLegal(...) and buildLegalEnvelope(...) are still TODO, as I haven’t seen your non-individual beans or map function. Send me those classes and the DB table for the legal additional details, and I’ll write them, including the SQL and a bool()-style row mapper.

Individualflow changes
Code·JAVA 
Nonindividualflow changes
Code·JAVA 
Cersaisubmitter
Code·JAVA 
