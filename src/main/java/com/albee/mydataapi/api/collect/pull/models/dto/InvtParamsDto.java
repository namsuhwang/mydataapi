package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class InvtParamsDto extends ApiCallParamsDto {

    public InvtParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 금융투자 목록
    public HashMap<String, Object> getParamsInvt001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 계좌 기본정보
    public HashMap<String, Object> getParamsInvt002(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 계좌 거래내역
    public HashMap<String, Object> getParamsInvt003(String accountNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 계좌 상품정보
    public HashMap<String, Object> getParamsInvt004(String accountNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 연금계좌 추가정보
    public HashMap<String, Object> getParamsInvt005(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 계좌지정 자동이체 등록정보
    public HashMap<String, Object> getParamsInvt006(String accountNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
