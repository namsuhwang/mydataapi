package com.abcc.mydataapi.api.collect.pull.models.dto;

import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class IrpParamsDto extends ApiCallParamsDto {

    public IrpParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 개인형 IRP 계좌목록
    public HashMap<String, Object> getParamsIrp001(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 개인형 IRP 계좌 기본
    public HashMap<String, Object> getParamsIrp002(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 개인형 IRP 계좌 추가
    public HashMap<String, Object> getParamsIrp003(String accountNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 개인형 IRP 계좌 거래내역
    public HashMap<String, Object> getParamsIrp004(String accountNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
