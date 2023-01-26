package com.kpcnc.mydataapi.api.collect.pull.models.dto;

import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class DcParamsDto extends ApiCallParamsDto {

    public DcParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // DC형 퇴직연금 목록
    public HashMap<String, Object> getParamsDc001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // DC형 퇴직연금 기본정보
    public HashMap<String, Object> getParamsDc002(String dcNum, Long searchTimeStamp){
        this.paramsMap.put("dc_num", dcNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // DC형 퇴직연금 거래내역
    public HashMap<String, Object> getParamsDc003(String dcNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("dc_num", dcNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // DC형 퇴직연금 추가정보
    public HashMap<String, Object> getParamsDc004(String dcNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("dc_num", dcNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
