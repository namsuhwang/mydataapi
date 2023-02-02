package com.abcc.mydataapi.api.common.recv.service;

import java.util.HashMap;


public interface RequestBankParamsSetService {
    public HashMap<String, Object> getParamsBank001(String memberId, String orgCd);

    public HashMap<String, Object> getParamsBank002(String memberId, String orgCd, String accountNum, String seqno);

    public HashMap<String, Object> getParamsBank003(String memberId, String orgCd, String accountNum, String seqno);
}
