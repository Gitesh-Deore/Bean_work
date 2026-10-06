package com.yourapp.ckyc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/** Generic: runs every query listed in cersai.query.keys and merges the first row of each. */
@Repository
@PropertySource("classpath:cersai-queries.properties")
public class CersaiDao {

    @Autowired private NamedParameterJdbcTemplate namedJdbc;
    @Autowired private Environment env;

    public Map<String, Object> fetchSubmitData(String applicationId, String loginUserId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("appId", applicationId);
        params.put("uid", loginUserId);

        Map<String, Object> out = new HashMap<String, Object>();
        for (String key : env.getRequiredProperty("cersai.query.keys").split(",")) {
            String sql = env.getRequiredProperty(key.trim());
            List<Map<String, Object>> rows = namedJdbc.queryForList(sql, params);
            if (rows.isEmpty()) {
                throw new IllegalStateException("No data returned for " + key.trim());
            }
            for (Map.Entry<String, Object> e : rows.get(0).entrySet()) {
                out.put(e.getKey().toUpperCase(), e.getValue());   // keys always upper-case
            }
        }
        return out;
    }

    public void saveResponse(String applicationId, String reqRefNo, String response) {
        Map<String, Object> p = new HashMap<String, Object>();
        p.put("appId", applicationId);
        p.put("ref", reqRefNo);
        p.put("resp", response);
        namedJdbc.update(env.getRequiredProperty("cersai.query.audit"), p);
    }
}
