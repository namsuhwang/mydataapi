package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class DbParamsDto extends ApiCallParamsDto {

    public DbParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // DB 보유 여부
    public HashMap<String, Object> getParamsDb001(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

}
