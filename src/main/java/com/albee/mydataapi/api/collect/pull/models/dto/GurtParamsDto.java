package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class GurtParamsDto extends ApiCallParamsDto {

    public GurtParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 보증보험 목록
    public HashMap<String, Object> getParamsGurt001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 보증보험 기본정보
    public HashMap<String, Object> getParamsGurt002(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 보증보험 거래내역
    public HashMap<String, Object> getParamsGurt003(String insuNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
