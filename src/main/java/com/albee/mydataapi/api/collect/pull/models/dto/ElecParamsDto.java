package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class ElecParamsDto extends ApiCallParamsDto {

    public ElecParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 선불전자지급수단 목록
    public HashMap<String, Object> getParamsElec001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 선불전자지급수단 잔액정보
    public HashMap<String, Object> getParamsElec002(String fobId, String accountId, Long searchTimeStamp){
        this.paramsMap.put("fob_id", fobId);
        this.paramsMap.put("account_id", accountId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 선불전자지급수단 자동충전정보
    public HashMap<String, Object> getParamsElec003(String fobId, String accountId, Long searchTimeStamp){
        this.paramsMap.put("fob_id", fobId);
        this.paramsMap.put("account_id", accountId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 선불 거래내역
    public HashMap<String, Object> getParamsElec004(String fobId, String accountId, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("fob_id", fobId);
        this.paramsMap.put("account_id", accountId);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 계정 목록
    public HashMap<String, Object> getParamsElec101(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 결제수단 등록 정보
    public HashMap<String, Object> getParamsElec102(String subKey, Long searchTimeStamp){
        this.paramsMap.put("sub_key", subKey);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 결제내역
    public HashMap<String, Object> getParamsElec103(String subKey,  String fromDate, String toDate, String nextPage){
        this.paramsMap.put("sub_key", subKey);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
