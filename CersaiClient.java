package com.yourapp.ckyc.client;

import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourapp.ckyc.service.CersaiCrypto;
import com.yourapp.ckyc.service.CersaiPayloadBuilder;

@Component
public class CersaiClient {

    private static final Logger log = LoggerFactory.getLogger(CersaiClient.class);

    @Autowired private RestTemplate restTemplate;
    @Autowired private CersaiCrypto crypto;
    @Value("${cersai.api.url}") private String cersaiUrl;

    private final ObjectMapper mapper = new ObjectMapper();

    public String send(CersaiPayloadBuilder builder, Map<String, Object> db,
                       Map<String, Object> innerData) throws Exception {

        // 1. inner JSON -> encrypted string -> goes into ckycInq.dataFor_encryptedData
        String encrypted = crypto.encrypt(mapper.writeValueAsString(innerData));

        // 2. outer envelope
        String refNo = "SBIK" + System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 4);
        db.put("REQ_REF_NO", refNo);
        Map<String, Object> envelope = builder.buildEnvelope(db, encrypted, refNo);

        // 3. DIGI_SIGN (assumed: signature over the REQUEST block - confirm with CERSAI spec)
        String requestJson = mapper.writeValueAsString(envelope.get("REQUEST"));
        envelope.put("DIGI_SIGN", crypto.sign(requestJson));

        // 4. POST
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.set("Authorization", "...");  // if CERSAI/gateway needs it
        HttpEntity<String> entity = new HttpEntity<String>(mapper.writeValueAsString(envelope), headers);

        log.info("Calling CERSAI refNo={}", refNo);   // never log the payload: it has Aadhaar/PAN/photo
        ResponseEntity<String> resp = restTemplate.exchange(cersaiUrl, HttpMethod.POST, entity, String.class);
        return resp.getBody();
    }
}
