package com.yourapp.ckyc.service;

import com.yourapp.ckyc.bean.CkycForm;

public interface CersaiService {
    String submitToCersai(CkycForm form, String loginUserId) throws Exception;
}
