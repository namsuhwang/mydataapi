package com.kpcnc.mydataapi.api.collect.pull.models.dto;

import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;

import java.util.HashMap;

public class BankParamsDto extends ApiCallParamsDto {


    public BankParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 계좌목록
    public HashMap<String, Object> bank001(String searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 수신계좌 기본
    public HashMap<String, Object> bank002(String accountNum, Integer seqno, String searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 수신계좌 추가
    public HashMap<String, Object> bank003(String accountNum, Integer seqno, String searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 수신계좌 거래내역
    public HashMap<String, Object> bank004(String accountNum, Integer seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

}
