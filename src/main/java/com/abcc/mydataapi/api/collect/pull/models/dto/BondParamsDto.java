package com.abcc.mydataapi.api.collect.pull.models.dto;

import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class BondParamsDto extends ApiCallParamsDto {

    public BondParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 인수채권/금전대부 목록
    public HashMap<String, Object> getParamsBond001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 인수채권/금전대부 잔액정보
    public HashMap<String, Object> getParamsBond002(String bondNum, Long searchTimeStamp){
        this.paramsMap.put("bond_num", bondNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 인수채권/금전대부 거래내역
    public HashMap<String, Object> getParamsBond003(String bondNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("bond_num", bondNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

}
