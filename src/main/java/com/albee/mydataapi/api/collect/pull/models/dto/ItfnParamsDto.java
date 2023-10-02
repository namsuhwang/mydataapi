package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class ItfnParamsDto extends ApiCallParamsDto {

    public ItfnParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 할부금융 목록
    public HashMap<String, Object> getParamsItfn001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 대출상품계좌 기본정보
    public HashMap<String, Object> getParamsItfn002(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 대출상품계좌 추가정보
    public HashMap<String, Object> getParamsItfn003(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }


    // 운용리스 기본정보
    public HashMap<String, Object> getParamsItfn004(String accountNum, String seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 운용리스 기본정보
    public HashMap<String, Object> getParamsItfn005(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 운용리스 거래내역
    public HashMap<String, Object> getParamsItfn006(String accountNum, String seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
