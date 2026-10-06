package com.yourapp.ckyc.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourapp.ckyc.bean.CkycForm;
import com.yourapp.ckyc.client.CersaiClient;
import com.yourapp.ckyc.dao.CersaiDao;

@Service
public class CersaiServiceImpl implements CersaiService {

    @Autowired private CersaiDao cersaiDao;
    @Autowired private CersaiPayloadBuilder payloadBuilder;
    @Autowired private CersaiClient cersaiClient;

    @Override
    public String submitToCersai(CkycForm form, String loginUserId) throws Exception {
        // 1. DB data - SQL comes from cersai-queries.properties (edit only that file)
        Map<String, Object> db = cersaiDao.fetchSubmitData(form.getApplicationId(), loginUserId);

        // 2. inner JSON from form bean + db data
        Map<String, Object> inner = payloadBuilder.buildInnerData(form, db);

        // 3. encrypt, sign, POST to CERSAI
        String response = cersaiClient.send(payloadBuilder, db, inner);

        // 4. audit
        cersaiDao.saveResponse(form.getApplicationId(), String.valueOf(db.get("REQ_REF_NO")), response);
        return response;
    }
}
