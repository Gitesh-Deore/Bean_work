package com.yourapp.ckyc.dto;

import java.util.List;

/**
 * Single-file nested DTO for the CERSAI CKYC create request.
 * Field names are identical to the JSON keys (no annotations) - use the field-based ObjectMapper config.
 * CkycData = inner object that is encrypted into ckycInq.dataFor_encryptedData.
 */
public class CersaiRequest {

    private String REQUEST_REFERENCE_NUMBER;
    private RequestBlock REQUEST;
    private String DIGI_SIGN;

    public String getREQUEST_REFERENCE_NUMBER() { return REQUEST_REFERENCE_NUMBER; }
    public void setREQUEST_REFERENCE_NUMBER(String REQUEST_REFERENCE_NUMBER) { this.REQUEST_REFERENCE_NUMBER = REQUEST_REFERENCE_NUMBER; }

    public RequestBlock getREQUEST() { return REQUEST; }
    public void setREQUEST(RequestBlock REQUEST) { this.REQUEST = REQUEST; }

    public String getDIGI_SIGN() { return DIGI_SIGN; }
    public void setDIGI_SIGN(String DIGI_SIGN) { this.DIGI_SIGN = DIGI_SIGN; }

    @Override
    public String toString() {
        return "CersaiRequest{" +
            "REQUEST_REFERENCE_NUMBER=" + REQUEST_REFERENCE_NUMBER +
            ", " + "REQUEST=" + REQUEST +
            ", " + "DIGI_SIGN=" + DIGI_SIGN +
            "}";
    }

    public static class RequestBlock {

        private String SOURCE_ID;
        private String CHANNEL_ID;
        private String BRANCH_CODE;
        private String CIF_NUMBER;
        private String DESTINATION;
        private String TXN_TYPE;
        private String TXN_SUB_TYPE;
        private EisPayload EIS_PAYLOAD;

        public String getSOURCE_ID() { return SOURCE_ID; }
        public void setSOURCE_ID(String SOURCE_ID) { this.SOURCE_ID = SOURCE_ID; }

        public String getCHANNEL_ID() { return CHANNEL_ID; }
        public void setCHANNEL_ID(String CHANNEL_ID) { this.CHANNEL_ID = CHANNEL_ID; }

        public String getBRANCH_CODE() { return BRANCH_CODE; }
        public void setBRANCH_CODE(String BRANCH_CODE) { this.BRANCH_CODE = BRANCH_CODE; }

        public String getCIF_NUMBER() { return CIF_NUMBER; }
        public void setCIF_NUMBER(String CIF_NUMBER) { this.CIF_NUMBER = CIF_NUMBER; }

        public String getDESTINATION() { return DESTINATION; }
        public void setDESTINATION(String DESTINATION) { this.DESTINATION = DESTINATION; }

        public String getTXN_TYPE() { return TXN_TYPE; }
        public void setTXN_TYPE(String TXN_TYPE) { this.TXN_TYPE = TXN_TYPE; }

        public String getTXN_SUB_TYPE() { return TXN_SUB_TYPE; }
        public void setTXN_SUB_TYPE(String TXN_SUB_TYPE) { this.TXN_SUB_TYPE = TXN_SUB_TYPE; }

        public EisPayload getEIS_PAYLOAD() { return EIS_PAYLOAD; }
        public void setEIS_PAYLOAD(EisPayload EIS_PAYLOAD) { this.EIS_PAYLOAD = EIS_PAYLOAD; }

        @Override
        public String toString() {
            return "RequestBlock{" +
                "SOURCE_ID=" + SOURCE_ID +
                ", " + "CHANNEL_ID=" + CHANNEL_ID +
                ", " + "BRANCH_CODE=" + BRANCH_CODE +
                ", " + "CIF_NUMBER=" + CIF_NUMBER +
                ", " + "DESTINATION=" + DESTINATION +
                ", " + "TXN_TYPE=" + TXN_TYPE +
                ", " + "TXN_SUB_TYPE=" + TXN_SUB_TYPE +
                ", " + "EIS_PAYLOAD=" + EIS_PAYLOAD +
                "}";
        }
    }

    public static class EisPayload {

        private EisBody BODY;

        public EisBody getBODY() { return BODY; }
        public void setBODY(EisBody BODY) { this.BODY = BODY; }

        @Override
        public String toString() {
            return "EisPayload{" +
                "BODY=" + BODY +
                "}";
        }
    }

    public static class EisBody {

        private String relId;
        private String requestId;
        private String timestamp;
        private CkycInq ckycInq;

        public String getRelId() { return relId; }
        public void setRelId(String relId) { this.relId = relId; }

        public String getRequestId() { return requestId; }
        public void setRequestId(String requestId) { this.requestId = requestId; }

        public String getTimestamp() { return timestamp; }
        public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

        public CkycInq getCkycInq() { return ckycInq; }
        public void setCkycInq(CkycInq ckycInq) { this.ckycInq = ckycInq; }

        @Override
        public String toString() {
            return "EisBody{" +
                "relId=" + relId +
                ", " + "requestId=" + requestId +
                ", " + "timestamp=" + timestamp +
                ", " + "ckycInq=" + ckycInq +
                "}";
        }
    }

    public static class CkycInq {

        private String ckycType;
        private String dataFor_encryptedData;

        public String getCkycType() { return ckycType; }
        public void setCkycType(String ckycType) { this.ckycType = ckycType; }

        public String getDataFor_encryptedData() { return dataFor_encryptedData; }
        public void setDataFor_encryptedData(String dataFor_encryptedData) { this.dataFor_encryptedData = dataFor_encryptedData; }

        @Override
        public String toString() {
            return "CkycInq{" +
                "ckycType=" + ckycType +
                ", " + "dataFor_encryptedData=" + dataFor_encryptedData +
                "}";
        }
    }

    public static class CkycData {

        private String searchKey;
        private String accountType;
        private PersonalDetails personalDetails;
        private OvdMatchingDetails ovdMatchingDetails;
        private ResidencyDetails residencyDetails;
        private DisabilityDetails disabilityDetails;
        private DocumentFile photo;
        private List<IdentityProof> identityProofs;
        private AddressDetails addressDetails;
        private ContactDetails contactDetails;
        private List<RelatedParty> relatedParties;
        private OtherDetails otherDetails;
        private AttestationDetails attestationDetails;
        private DocumentFile undertakingDocument;

        public String getSearchKey() { return searchKey; }
        public void setSearchKey(String searchKey) { this.searchKey = searchKey; }

        public String getAccountType() { return accountType; }
        public void setAccountType(String accountType) { this.accountType = accountType; }

        public PersonalDetails getPersonalDetails() { return personalDetails; }
        public void setPersonalDetails(PersonalDetails personalDetails) { this.personalDetails = personalDetails; }

        public OvdMatchingDetails getOvdMatchingDetails() { return ovdMatchingDetails; }
        public void setOvdMatchingDetails(OvdMatchingDetails ovdMatchingDetails) { this.ovdMatchingDetails = ovdMatchingDetails; }

        public ResidencyDetails getResidencyDetails() { return residencyDetails; }
        public void setResidencyDetails(ResidencyDetails residencyDetails) { this.residencyDetails = residencyDetails; }

        public DisabilityDetails getDisabilityDetails() { return disabilityDetails; }
        public void setDisabilityDetails(DisabilityDetails disabilityDetails) { this.disabilityDetails = disabilityDetails; }

        public DocumentFile getPhoto() { return photo; }
        public void setPhoto(DocumentFile photo) { this.photo = photo; }

        public List<IdentityProof> getIdentityProofs() { return identityProofs; }
        public void setIdentityProofs(List<IdentityProof> identityProofs) { this.identityProofs = identityProofs; }

        public AddressDetails getAddressDetails() { return addressDetails; }
        public void setAddressDetails(AddressDetails addressDetails) { this.addressDetails = addressDetails; }

        public ContactDetails getContactDetails() { return contactDetails; }
        public void setContactDetails(ContactDetails contactDetails) { this.contactDetails = contactDetails; }

        public List<RelatedParty> getRelatedParties() { return relatedParties; }
        public void setRelatedParties(List<RelatedParty> relatedParties) { this.relatedParties = relatedParties; }

        public OtherDetails getOtherDetails() { return otherDetails; }
        public void setOtherDetails(OtherDetails otherDetails) { this.otherDetails = otherDetails; }

        public AttestationDetails getAttestationDetails() { return attestationDetails; }
        public void setAttestationDetails(AttestationDetails attestationDetails) { this.attestationDetails = attestationDetails; }

        public DocumentFile getUndertakingDocument() { return undertakingDocument; }
        public void setUndertakingDocument(DocumentFile undertakingDocument) { this.undertakingDocument = undertakingDocument; }

        @Override
        public String toString() {
            return "CkycData{" +
                "searchKey=" + searchKey +
                ", " + "accountType=" + accountType +
                ", " + "personalDetails=" + personalDetails +
                ", " + "ovdMatchingDetails=" + ovdMatchingDetails +
                ", " + "residencyDetails=" + residencyDetails +
                ", " + "disabilityDetails=" + disabilityDetails +
                ", " + "photo=" + photo +
                ", " + "identityProofs=" + identityProofs +
                ", " + "addressDetails=" + addressDetails +
                ", " + "contactDetails=" + contactDetails +
                ", " + "relatedParties=" + relatedParties +
                ", " + "otherDetails=" + otherDetails +
                ", " + "attestationDetails=" + attestationDetails +
                ", " + "undertakingDocument=" + undertakingDocument +
                "}";
        }
    }

    public static class PersonalDetails {

        private PersonName name;
        private FamilyDetails familyDetails;
        private String dob;
        private Boolean isMinor;
        private String gender;
        private PanDetails panDetails;

        public PersonName getName() { return name; }
        public void setName(PersonName name) { this.name = name; }

        public FamilyDetails getFamilyDetails() { return familyDetails; }
        public void setFamilyDetails(FamilyDetails familyDetails) { this.familyDetails = familyDetails; }

        public String getDob() { return dob; }
        public void setDob(String dob) { this.dob = dob; }

        public Boolean getIsMinor() { return isMinor; }
        public void setIsMinor(Boolean isMinor) { this.isMinor = isMinor; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public PanDetails getPanDetails() { return panDetails; }
        public void setPanDetails(PanDetails panDetails) { this.panDetails = panDetails; }

        @Override
        public String toString() {
            return "PersonalDetails{" +
                "name=" + name +
                ", " + "familyDetails=" + familyDetails +
                ", " + "dob=" + dob +
                ", " + "isMinor=" + isMinor +
                ", " + "gender=" + gender +
                ", " + "panDetails=" + panDetails +
                "}";
        }
    }

    public static class PersonName {

        private String title;
        private String firstName;
        private String middleName;
        private String lastName;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getMiddleName() { return middleName; }
        public void setMiddleName(String middleName) { this.middleName = middleName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        @Override
        public String toString() {
            return "PersonName{" +
                "title=" + title +
                ", " + "firstName=" + firstName +
                ", " + "middleName=" + middleName +
                ", " + "lastName=" + lastName +
                "}";
        }
    }

    public static class FamilyDetails {

        private PersonName father;
        private PersonName mother;
        private PersonName maidenName;
        private PersonName spouse;

        public PersonName getFather() { return father; }
        public void setFather(PersonName father) { this.father = father; }

        public PersonName getMother() { return mother; }
        public void setMother(PersonName mother) { this.mother = mother; }

        public PersonName getMaidenName() { return maidenName; }
        public void setMaidenName(PersonName maidenName) { this.maidenName = maidenName; }

        public PersonName getSpouse() { return spouse; }
        public void setSpouse(PersonName spouse) { this.spouse = spouse; }

        @Override
        public String toString() {
            return "FamilyDetails{" +
                "father=" + father +
                ", " + "mother=" + mother +
                ", " + "maidenName=" + maidenName +
                ", " + "spouse=" + spouse +
                "}";
        }
    }

    public static class PanDetails {

        private String number;
        private Boolean form97Submitted;
        private Boolean verified;
        private PanDocument document;

        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }

        public Boolean getForm97Submitted() { return form97Submitted; }
        public void setForm97Submitted(Boolean form97Submitted) { this.form97Submitted = form97Submitted; }

        public Boolean getVerified() { return verified; }
        public void setVerified(Boolean verified) { this.verified = verified; }

        public PanDocument getDocument() { return document; }
        public void setDocument(PanDocument document) { this.document = document; }

        @Override
        public String toString() {
            return "PanDetails{" +
                "number=" + number +
                ", " + "form97Submitted=" + form97Submitted +
                ", " + "verified=" + verified +
                ", " + "document=" + document +
                "}";
        }
    }

    public static class PanDocument {

        private String b64Content;
        private String contentType;

        public String getB64Content() { return b64Content; }
        public void setB64Content(String b64Content) { this.b64Content = b64Content; }

        public String getContentType() { return contentType; }
        public void setContentType(String contentType) { this.contentType = contentType; }

        @Override
        public String toString() {
            return "PanDocument{" +
                "b64Content=" + (b64Content == null ? null : "[len=" + b64Content.length() + "]") +
                ", " + "contentType=" + contentType +
                "}";
        }
    }

    public static class OvdMatchingDetails {

        private Boolean dob;
        private Boolean name;
        private Boolean gender;
        private Boolean photo;
        private Boolean genderMentionedInOvd;

        public Boolean getDob() { return dob; }
        public void setDob(Boolean dob) { this.dob = dob; }

        public Boolean getName() { return name; }
        public void setName(Boolean name) { this.name = name; }

        public Boolean getGender() { return gender; }
        public void setGender(Boolean gender) { this.gender = gender; }

        public Boolean getPhoto() { return photo; }
        public void setPhoto(Boolean photo) { this.photo = photo; }

        public Boolean getGenderMentionedInOvd() { return genderMentionedInOvd; }
        public void setGenderMentionedInOvd(Boolean genderMentionedInOvd) { this.genderMentionedInOvd = genderMentionedInOvd; }

        @Override
        public String toString() {
            return "OvdMatchingDetails{" +
                "dob=" + dob +
                ", " + "name=" + name +
                ", " + "gender=" + gender +
                ", " + "photo=" + photo +
                ", " + "genderMentionedInOvd=" + genderMentionedInOvd +
                "}";
        }
    }

    public static class ResidencyDetails {

        private String residentialStatus;
        private Boolean residentialStatusSupportedByDoc;
        private String nationality;
        private Boolean nationalitySupportedByDoc;

        public String getResidentialStatus() { return residentialStatus; }
        public void setResidentialStatus(String residentialStatus) { this.residentialStatus = residentialStatus; }

        public Boolean getResidentialStatusSupportedByDoc() { return residentialStatusSupportedByDoc; }
        public void setResidentialStatusSupportedByDoc(Boolean residentialStatusSupportedByDoc) { this.residentialStatusSupportedByDoc = residentialStatusSupportedByDoc; }

        public String getNationality() { return nationality; }
        public void setNationality(String nationality) { this.nationality = nationality; }

        public Boolean getNationalitySupportedByDoc() { return nationalitySupportedByDoc; }
        public void setNationalitySupportedByDoc(Boolean nationalitySupportedByDoc) { this.nationalitySupportedByDoc = nationalitySupportedByDoc; }

        @Override
        public String toString() {
            return "ResidencyDetails{" +
                "residentialStatus=" + residentialStatus +
                ", " + "residentialStatusSupportedByDoc=" + residentialStatusSupportedByDoc +
                ", " + "nationality=" + nationality +
                ", " + "nationalitySupportedByDoc=" + nationalitySupportedByDoc +
                "}";
        }
    }

    public static class DisabilityDetails {

        private Boolean hasDisability;
        private Boolean supportedByDoc;
        private String type;
        private String percentage;
        private String udidNumber;

        public Boolean getHasDisability() { return hasDisability; }
        public void setHasDisability(Boolean hasDisability) { this.hasDisability = hasDisability; }

        public Boolean getSupportedByDoc() { return supportedByDoc; }
        public void setSupportedByDoc(Boolean supportedByDoc) { this.supportedByDoc = supportedByDoc; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getPercentage() { return percentage; }
        public void setPercentage(String percentage) { this.percentage = percentage; }

        public String getUdidNumber() { return udidNumber; }
        public void setUdidNumber(String udidNumber) { this.udidNumber = udidNumber; }

        @Override
        public String toString() {
            return "DisabilityDetails{" +
                "hasDisability=" + hasDisability +
                ", " + "supportedByDoc=" + supportedByDoc +
                ", " + "type=" + type +
                ", " + "percentage=" + percentage +
                ", " + "udidNumber=" + udidNumber +
                "}";
        }
    }

    public static class DocumentFile {

        private String documentName;
        private String b64Content;
        private String contentType;

        public String getDocumentName() { return documentName; }
        public void setDocumentName(String documentName) { this.documentName = documentName; }

        public String getB64Content() { return b64Content; }
        public void setB64Content(String b64Content) { this.b64Content = b64Content; }

        public String getContentType() { return contentType; }
        public void setContentType(String contentType) { this.contentType = contentType; }

        @Override
        public String toString() {
            return "DocumentFile{" +
                "documentName=" + documentName +
                ", " + "b64Content=" + (b64Content == null ? null : "[len=" + b64Content.length() + "]") +
                ", " + "contentType=" + contentType +
                "}";
        }
    }

    public static class IdentityProof {

        private String docIdentityCode;
        private String ovdNo;
        private IdentityVerification verification;
        private EkycDetails ekycDetails;
        private List<DocumentFile> documents;

        public String getDocIdentityCode() { return docIdentityCode; }
        public void setDocIdentityCode(String docIdentityCode) { this.docIdentityCode = docIdentityCode; }

        public String getOvdNo() { return ovdNo; }
        public void setOvdNo(String ovdNo) { this.ovdNo = ovdNo; }

        public IdentityVerification getVerification() { return verification; }
        public void setVerification(IdentityVerification verification) { this.verification = verification; }

        public EkycDetails getEkycDetails() { return ekycDetails; }
        public void setEkycDetails(EkycDetails ekycDetails) { this.ekycDetails = ekycDetails; }

        public List<DocumentFile> getDocuments() { return documents; }
        public void setDocuments(List<DocumentFile> documents) { this.documents = documents; }

        @Override
        public String toString() {
            return "IdentityProof{" +
                "docIdentityCode=" + docIdentityCode +
                ", " + "ovdNo=" + ovdNo +
                ", " + "verification=" + verification +
                ", " + "ekycDetails=" + ekycDetails +
                ", " + "documents=" + documents +
                "}";
        }
    }

    public static class IdentityVerification {

        private Boolean certifiedCopyVerifiedWithOriginalOVD;
        private Boolean equivalentEDoc;
        private Boolean verifiedFromDigilocker;

        public Boolean getCertifiedCopyVerifiedWithOriginalOVD() { return certifiedCopyVerifiedWithOriginalOVD; }
        public void setCertifiedCopyVerifiedWithOriginalOVD(Boolean certifiedCopyVerifiedWithOriginalOVD) { this.certifiedCopyVerifiedWithOriginalOVD = certifiedCopyVerifiedWithOriginalOVD; }

        public Boolean getEquivalentEDoc() { return equivalentEDoc; }
        public void setEquivalentEDoc(Boolean equivalentEDoc) { this.equivalentEDoc = equivalentEDoc; }

        public Boolean getVerifiedFromDigilocker() { return verifiedFromDigilocker; }
        public void setVerifiedFromDigilocker(Boolean verifiedFromDigilocker) { this.verifiedFromDigilocker = verifiedFromDigilocker; }

        @Override
        public String toString() {
            return "IdentityVerification{" +
                "certifiedCopyVerifiedWithOriginalOVD=" + certifiedCopyVerifiedWithOriginalOVD +
                ", " + "equivalentEDoc=" + equivalentEDoc +
                ", " + "verifiedFromDigilocker=" + verifiedFromDigilocker +
                "}";
        }
    }

    public static class EkycDetails {

        private String modeOfAadhaarVerification;

        public String getModeOfAadhaarVerification() { return modeOfAadhaarVerification; }
        public void setModeOfAadhaarVerification(String modeOfAadhaarVerification) { this.modeOfAadhaarVerification = modeOfAadhaarVerification; }

        @Override
        public String toString() {
            return "EkycDetails{" +
                "modeOfAadhaarVerification=" + modeOfAadhaarVerification +
                "}";
        }
    }

    public static class AddressDetails {

        private PermanentAddress addressAsPerOvd;
        private CurrentAddress currentAddress;

        public PermanentAddress getAddressAsPerOvd() { return addressAsPerOvd; }
        public void setAddressAsPerOvd(PermanentAddress addressAsPerOvd) { this.addressAsPerOvd = addressAsPerOvd; }

        public CurrentAddress getCurrentAddress() { return currentAddress; }
        public void setCurrentAddress(CurrentAddress currentAddress) { this.currentAddress = currentAddress; }

        @Override
        public String toString() {
            return "AddressDetails{" +
                "addressAsPerOvd=" + addressAsPerOvd +
                ", " + "currentAddress=" + currentAddress +
                "}";
        }
    }

    public static class AddressBase {

        private String line1;
        private String line2;
        private String line3;
        private String countryCode;
        private String state;
        private String stateOthers;
        private String district;
        private String city;
        private String pincode;
        private String pincodeOther;
        private String addressType;

        public String getLine1() { return line1; }
        public void setLine1(String line1) { this.line1 = line1; }

        public String getLine2() { return line2; }
        public void setLine2(String line2) { this.line2 = line2; }

        public String getLine3() { return line3; }
        public void setLine3(String line3) { this.line3 = line3; }

        public String getCountryCode() { return countryCode; }
        public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

        public String getState() { return state; }
        public void setState(String state) { this.state = state; }

        public String getStateOthers() { return stateOthers; }
        public void setStateOthers(String stateOthers) { this.stateOthers = stateOthers; }

        public String getDistrict() { return district; }
        public void setDistrict(String district) { this.district = district; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getPincode() { return pincode; }
        public void setPincode(String pincode) { this.pincode = pincode; }

        public String getPincodeOther() { return pincodeOther; }
        public void setPincodeOther(String pincodeOther) { this.pincodeOther = pincodeOther; }

        public String getAddressType() { return addressType; }
        public void setAddressType(String addressType) { this.addressType = addressType; }

        @Override
        public String toString() {
            return "AddressBase{" +
                "line1=" + line1 +
                ", " + "line2=" + line2 +
                ", " + "line3=" + line3 +
                ", " + "countryCode=" + countryCode +
                ", " + "state=" + state +
                ", " + "stateOthers=" + stateOthers +
                ", " + "district=" + district +
                ", " + "city=" + city +
                ", " + "pincode=" + pincode +
                ", " + "pincodeOther=" + pincodeOther +
                ", " + "addressType=" + addressType +
                "}";
        }
    }

    public static class PermanentAddress extends AddressBase {

        private Boolean matchWithOvd;
        private Boolean supportedByDoc;
        private PermanentAddressVerification verification;

        public Boolean getMatchWithOvd() { return matchWithOvd; }
        public void setMatchWithOvd(Boolean matchWithOvd) { this.matchWithOvd = matchWithOvd; }

        public Boolean getSupportedByDoc() { return supportedByDoc; }
        public void setSupportedByDoc(Boolean supportedByDoc) { this.supportedByDoc = supportedByDoc; }

        public PermanentAddressVerification getVerification() { return verification; }
        public void setVerification(PermanentAddressVerification verification) { this.verification = verification; }

        @Override
        public String toString() {
            return "PermanentAddress{" +
                "super=" + super.toString() +
                ", " + "matchWithOvd=" + matchWithOvd +
                ", " + "supportedByDoc=" + supportedByDoc +
                ", " + "verification=" + verification +
                "}";
        }
    }

    public static class PermanentAddressVerification {

        private String addressAsPerOvdAddressMatchWithOvdMatchType;

        public String getAddressAsPerOvdAddressMatchWithOvdMatchType() { return addressAsPerOvdAddressMatchWithOvdMatchType; }
        public void setAddressAsPerOvdAddressMatchWithOvdMatchType(String addressAsPerOvdAddressMatchWithOvdMatchType) { this.addressAsPerOvdAddressMatchWithOvdMatchType = addressAsPerOvdAddressMatchWithOvdMatchType; }

        @Override
        public String toString() {
            return "PermanentAddressVerification{" +
                "addressAsPerOvdAddressMatchWithOvdMatchType=" + addressAsPerOvdAddressMatchWithOvdMatchType +
                "}";
        }
    }

    public static class CurrentAddress extends AddressBase {

        private Boolean sameAsAddressAsPerOvd;
        private ProofOfAddress proofOfAddress;
        private RepositoryPresence repositoryPresence;
        private CurrentAddressVerification verification;
        private List<AddressDocument> documents;

        public Boolean getSameAsAddressAsPerOvd() { return sameAsAddressAsPerOvd; }
        public void setSameAsAddressAsPerOvd(Boolean sameAsAddressAsPerOvd) { this.sameAsAddressAsPerOvd = sameAsAddressAsPerOvd; }

        public ProofOfAddress getProofOfAddress() { return proofOfAddress; }
        public void setProofOfAddress(ProofOfAddress proofOfAddress) { this.proofOfAddress = proofOfAddress; }

        public RepositoryPresence getRepositoryPresence() { return repositoryPresence; }
        public void setRepositoryPresence(RepositoryPresence repositoryPresence) { this.repositoryPresence = repositoryPresence; }

        public CurrentAddressVerification getVerification() { return verification; }
        public void setVerification(CurrentAddressVerification verification) { this.verification = verification; }

        public List<AddressDocument> getDocuments() { return documents; }
        public void setDocuments(List<AddressDocument> documents) { this.documents = documents; }

        @Override
        public String toString() {
            return "CurrentAddress{" +
                "super=" + super.toString() +
                ", " + "sameAsAddressAsPerOvd=" + sameAsAddressAsPerOvd +
                ", " + "proofOfAddress=" + proofOfAddress +
                ", " + "repositoryPresence=" + repositoryPresence +
                ", " + "verification=" + verification +
                ", " + "documents=" + documents +
                "}";
        }
    }

    public static class ProofOfAddress {

        private String type;
        private String docIdentityCode;
        private String ovdNo;
        private String aadhaarType;
        private String passportExpiryDate;
        private String drivingLicenseExpiryDate;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getDocIdentityCode() { return docIdentityCode; }
        public void setDocIdentityCode(String docIdentityCode) { this.docIdentityCode = docIdentityCode; }

        public String getOvdNo() { return ovdNo; }
        public void setOvdNo(String ovdNo) { this.ovdNo = ovdNo; }

        public String getAadhaarType() { return aadhaarType; }
        public void setAadhaarType(String aadhaarType) { this.aadhaarType = aadhaarType; }

        public String getPassportExpiryDate() { return passportExpiryDate; }
        public void setPassportExpiryDate(String passportExpiryDate) { this.passportExpiryDate = passportExpiryDate; }

        public String getDrivingLicenseExpiryDate() { return drivingLicenseExpiryDate; }
        public void setDrivingLicenseExpiryDate(String drivingLicenseExpiryDate) { this.drivingLicenseExpiryDate = drivingLicenseExpiryDate; }

        @Override
        public String toString() {
            return "ProofOfAddress{" +
                "type=" + type +
                ", " + "docIdentityCode=" + docIdentityCode +
                ", " + "ovdNo=" + ovdNo +
                ", " + "aadhaarType=" + aadhaarType +
                ", " + "passportExpiryDate=" + passportExpiryDate +
                ", " + "drivingLicenseExpiryDate=" + drivingLicenseExpiryDate +
                "}";
        }
    }

    public static class RepositoryPresence {

        private Boolean passportInMea;
        private Boolean voterIdInEci;
        private Boolean drivingLicenseInRto;
        private Boolean nregaInRepository;
        private Boolean nprInCensusRecords;

        public Boolean getPassportInMea() { return passportInMea; }
        public void setPassportInMea(Boolean passportInMea) { this.passportInMea = passportInMea; }

        public Boolean getVoterIdInEci() { return voterIdInEci; }
        public void setVoterIdInEci(Boolean voterIdInEci) { this.voterIdInEci = voterIdInEci; }

        public Boolean getDrivingLicenseInRto() { return drivingLicenseInRto; }
        public void setDrivingLicenseInRto(Boolean drivingLicenseInRto) { this.drivingLicenseInRto = drivingLicenseInRto; }

        public Boolean getNregaInRepository() { return nregaInRepository; }
        public void setNregaInRepository(Boolean nregaInRepository) { this.nregaInRepository = nregaInRepository; }

        public Boolean getNprInCensusRecords() { return nprInCensusRecords; }
        public void setNprInCensusRecords(Boolean nprInCensusRecords) { this.nprInCensusRecords = nprInCensusRecords; }

        @Override
        public String toString() {
            return "RepositoryPresence{" +
                "passportInMea=" + passportInMea +
                ", " + "voterIdInEci=" + voterIdInEci +
                ", " + "drivingLicenseInRto=" + drivingLicenseInRto +
                ", " + "nregaInRepository=" + nregaInRepository +
                ", " + "nprInCensusRecords=" + nprInCensusRecords +
                "}";
        }
    }

    public static class CurrentAddressVerification {

        private Boolean certifiedCopyVerifiedWithOriginalOVD;
        private Boolean verifiedFromDigilocker;
        private Boolean equivalentEDoc;
        private Boolean currAddressExactlyMatchWithOvd;
        private String currAddressExactlyMatchWithOvdType;
        private Boolean remoteGeoTagging;
        private Boolean positiveVerification;
        private Boolean physicalByReOfficial;
        private Boolean physicalByThirdParty;

        public Boolean getCertifiedCopyVerifiedWithOriginalOVD() { return certifiedCopyVerifiedWithOriginalOVD; }
        public void setCertifiedCopyVerifiedWithOriginalOVD(Boolean certifiedCopyVerifiedWithOriginalOVD) { this.certifiedCopyVerifiedWithOriginalOVD = certifiedCopyVerifiedWithOriginalOVD; }

        public Boolean getVerifiedFromDigilocker() { return verifiedFromDigilocker; }
        public void setVerifiedFromDigilocker(Boolean verifiedFromDigilocker) { this.verifiedFromDigilocker = verifiedFromDigilocker; }

        public Boolean getEquivalentEDoc() { return equivalentEDoc; }
        public void setEquivalentEDoc(Boolean equivalentEDoc) { this.equivalentEDoc = equivalentEDoc; }

        public Boolean getCurrAddressExactlyMatchWithOvd() { return currAddressExactlyMatchWithOvd; }
        public void setCurrAddressExactlyMatchWithOvd(Boolean currAddressExactlyMatchWithOvd) { this.currAddressExactlyMatchWithOvd = currAddressExactlyMatchWithOvd; }

        public String getCurrAddressExactlyMatchWithOvdType() { return currAddressExactlyMatchWithOvdType; }
        public void setCurrAddressExactlyMatchWithOvdType(String currAddressExactlyMatchWithOvdType) { this.currAddressExactlyMatchWithOvdType = currAddressExactlyMatchWithOvdType; }

        public Boolean getRemoteGeoTagging() { return remoteGeoTagging; }
        public void setRemoteGeoTagging(Boolean remoteGeoTagging) { this.remoteGeoTagging = remoteGeoTagging; }

        public Boolean getPositiveVerification() { return positiveVerification; }
        public void setPositiveVerification(Boolean positiveVerification) { this.positiveVerification = positiveVerification; }

        public Boolean getPhysicalByReOfficial() { return physicalByReOfficial; }
        public void setPhysicalByReOfficial(Boolean physicalByReOfficial) { this.physicalByReOfficial = physicalByReOfficial; }

        public Boolean getPhysicalByThirdParty() { return physicalByThirdParty; }
        public void setPhysicalByThirdParty(Boolean physicalByThirdParty) { this.physicalByThirdParty = physicalByThirdParty; }

        @Override
        public String toString() {
            return "CurrentAddressVerification{" +
                "certifiedCopyVerifiedWithOriginalOVD=" + certifiedCopyVerifiedWithOriginalOVD +
                ", " + "verifiedFromDigilocker=" + verifiedFromDigilocker +
                ", " + "equivalentEDoc=" + equivalentEDoc +
                ", " + "currAddressExactlyMatchWithOvd=" + currAddressExactlyMatchWithOvd +
                ", " + "currAddressExactlyMatchWithOvdType=" + currAddressExactlyMatchWithOvdType +
                ", " + "remoteGeoTagging=" + remoteGeoTagging +
                ", " + "positiveVerification=" + positiveVerification +
                ", " + "physicalByReOfficial=" + physicalByReOfficial +
                ", " + "physicalByThirdParty=" + physicalByThirdParty +
                "}";
        }
    }

    public static class AddressDocument {

        private String documentType;
        private String documentName;
        private String b64Content;
        private String contentType;

        public String getDocumentType() { return documentType; }
        public void setDocumentType(String documentType) { this.documentType = documentType; }

        public String getDocumentName() { return documentName; }
        public void setDocumentName(String documentName) { this.documentName = documentName; }

        public String getB64Content() { return b64Content; }
        public void setB64Content(String b64Content) { this.b64Content = b64Content; }

        public String getContentType() { return contentType; }
        public void setContentType(String contentType) { this.contentType = contentType; }

        @Override
        public String toString() {
            return "AddressDocument{" +
                "documentType=" + documentType +
                ", " + "documentName=" + documentName +
                ", " + "b64Content=" + (b64Content == null ? null : "[len=" + b64Content.length() + "]") +
                ", " + "contentType=" + contentType +
                "}";
        }
    }

    public static class ContactDetails {

        private EmailDetails email;
        private MobileDetails mobile;

        public EmailDetails getEmail() { return email; }
        public void setEmail(EmailDetails email) { this.email = email; }

        public MobileDetails getMobile() { return mobile; }
        public void setMobile(MobileDetails mobile) { this.mobile = mobile; }

        @Override
        public String toString() {
            return "ContactDetails{" +
                "email=" + email +
                ", " + "mobile=" + mobile +
                "}";
        }
    }

    public static class EmailDetails {

        private String address;
        private Boolean verifiedThroughOTP;

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public Boolean getVerifiedThroughOTP() { return verifiedThroughOTP; }
        public void setVerifiedThroughOTP(Boolean verifiedThroughOTP) { this.verifiedThroughOTP = verifiedThroughOTP; }

        @Override
        public String toString() {
            return "EmailDetails{" +
                "address=" + address +
                ", " + "verifiedThroughOTP=" + verifiedThroughOTP +
                "}";
        }
    }

    public static class MobileDetails {

        private String countryCode;
        private String number;
        private Boolean verifiedThroughOTP;
        private Boolean verifiedThroughThirdParty;

        public String getCountryCode() { return countryCode; }
        public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }

        public Boolean getVerifiedThroughOTP() { return verifiedThroughOTP; }
        public void setVerifiedThroughOTP(Boolean verifiedThroughOTP) { this.verifiedThroughOTP = verifiedThroughOTP; }

        public Boolean getVerifiedThroughThirdParty() { return verifiedThroughThirdParty; }
        public void setVerifiedThroughThirdParty(Boolean verifiedThroughThirdParty) { this.verifiedThroughThirdParty = verifiedThroughThirdParty; }

        @Override
        public String toString() {
            return "MobileDetails{" +
                "countryCode=" + countryCode +
                ", " + "number=" + number +
                ", " + "verifiedThroughOTP=" + verifiedThroughOTP +
                ", " + "verifiedThroughThirdParty=" + verifiedThroughThirdParty +
                "}";
        }
    }

    public static class RelatedParty {

        private String relationType;
        private String ckycId;

        public String getRelationType() { return relationType; }
        public void setRelationType(String relationType) { this.relationType = relationType; }

        public String getCkycId() { return ckycId; }
        public void setCkycId(String ckycId) { this.ckycId = ckycId; }

        @Override
        public String toString() {
            return "RelatedParty{" +
                "relationType=" + relationType +
                ", " + "ckycId=" + ckycId +
                "}";
        }
    }

    public static class OtherDetails {

        private String remarks;

        public String getRemarks() { return remarks; }
        public void setRemarks(String remarks) { this.remarks = remarks; }

        @Override
        public String toString() {
            return "OtherDetails{" +
                "remarks=" + remarks +
                "}";
        }
    }

    public static class AttestationDetails {

        private Employee employee;
        private KycVerification kycVerification;
        private Declaration declaration;

        public Employee getEmployee() { return employee; }
        public void setEmployee(Employee employee) { this.employee = employee; }

        public KycVerification getKycVerification() { return kycVerification; }
        public void setKycVerification(KycVerification kycVerification) { this.kycVerification = kycVerification; }

        public Declaration getDeclaration() { return declaration; }
        public void setDeclaration(Declaration declaration) { this.declaration = declaration; }

        @Override
        public String toString() {
            return "AttestationDetails{" +
                "employee=" + employee +
                ", " + "kycVerification=" + kycVerification +
                ", " + "declaration=" + declaration +
                "}";
        }
    }

    public static class Employee {

        private String name;
        private String code;
        private String designation;
        private String branch;
        private String ckycId;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getDesignation() { return designation; }
        public void setDesignation(String designation) { this.designation = designation; }

        public String getBranch() { return branch; }
        public void setBranch(String branch) { this.branch = branch; }

        public String getCkycId() { return ckycId; }
        public void setCkycId(String ckycId) { this.ckycId = ckycId; }

        @Override
        public String toString() {
            return "Employee{" +
                "name=" + name +
                ", " + "code=" + code +
                ", " + "designation=" + designation +
                ", " + "branch=" + branch +
                ", " + "ckycId=" + ckycId +
                "}";
        }
    }

    public static class KycVerification {

        private String mode;
        private String carriedOutDate;
        private String remarks;

        public String getMode() { return mode; }
        public void setMode(String mode) { this.mode = mode; }

        public String getCarriedOutDate() { return carriedOutDate; }
        public void setCarriedOutDate(String carriedOutDate) { this.carriedOutDate = carriedOutDate; }

        public String getRemarks() { return remarks; }
        public void setRemarks(String remarks) { this.remarks = remarks; }

        @Override
        public String toString() {
            return "KycVerification{" +
                "mode=" + mode +
                ", " + "carriedOutDate=" + carriedOutDate +
                ", " + "remarks=" + remarks +
                "}";
        }
    }

    public static class Declaration {

        private String date;
        private String place;
        private DocumentFile supportingDocument;

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getPlace() { return place; }
        public void setPlace(String place) { this.place = place; }

        public DocumentFile getSupportingDocument() { return supportingDocument; }
        public void setSupportingDocument(DocumentFile supportingDocument) { this.supportingDocument = supportingDocument; }

        @Override
        public String toString() {
            return "Declaration{" +
                "date=" + date +
                ", " + "place=" + place +
                ", " + "supportingDocument=" + supportingDocument +
                "}";
        }
    }
}
