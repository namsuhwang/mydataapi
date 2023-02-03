package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class TeleParamsDto extends ApiCallParamsDto {

    public TeleParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 통신 목록
    public HashMap<String, Object> getParamsTele001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 청구 정보
    public HashMap<String, Object> getParamsTele002(String mgmtId, String fromMonth, String toMonth){
        this.paramsMap.put("mgmt_id", mgmtId);
        this.paramsMap.put("from_month", fromMonth);
        this.paramsMap.put("to_month", toMonth);
        return this.paramsMap;
    }

    // 통신 거래내역
    public HashMap<String, Object> getParamsTele003(String mgmtId, String fromMonth, String toMonth){
        this.paramsMap.put("mgmt_id", mgmtId);
        this.paramsMap.put("from_month", fromMonth);
        this.paramsMap.put("to_month", toMonth);
        return this.paramsMap;
    }

    // 결제내역
    public HashMap<String, Object> getParamsTele004(String mgmtId, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("mgmt_id", mgmtId);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
