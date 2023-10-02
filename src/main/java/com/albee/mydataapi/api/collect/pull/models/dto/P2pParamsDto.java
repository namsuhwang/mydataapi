package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class P2pParamsDto extends ApiCallParamsDto {

    public P2pParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // P2P 대출 목록
    public HashMap<String, Object> getParamsP2p001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // P2P 대출 기본정보
    public HashMap<String, Object> getParamsP2p002(String lendingId, Long searchTimeStamp){
        this.paramsMap.put("lending_id", lendingId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // P2P 대출 추가정보
    public HashMap<String, Object> getParamsP2p003(String lendingId, Long searchTimeStamp){
        this.paramsMap.put("lending_id", lendingId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // P2P 대출 거래내역
    public HashMap<String, Object> getParamsP2p004(String lendingId, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("lending_id", lendingId);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
