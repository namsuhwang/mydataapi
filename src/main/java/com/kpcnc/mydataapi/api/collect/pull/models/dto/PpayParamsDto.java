package com.kpcnc.mydataapi.api.collect.pull.models.dto;

import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class PpayParamsDto extends ApiCallParamsDto {

    public PpayParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 선불카드 목록
    public HashMap<String, Object> getParamsPpay001(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 선불카드 잔액
    public HashMap<String, Object> getParamsPpay002(String ppId, Long searchTimeStamp){
        this.paramsMap.put("pp_id", ppId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 선불카드 거래내역
    public HashMap<String, Object> getParamsPpay003(String ppId, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("pp_id", ppId);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 선불카드 승인내역
    public HashMap<String, Object> getParamsPpay004(String ppId, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("pp_id", ppId);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
