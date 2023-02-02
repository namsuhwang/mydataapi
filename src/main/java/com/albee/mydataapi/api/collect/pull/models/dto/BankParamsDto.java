package com.albee.mydataapi.api.collect.pull.models.dto;

import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class BankParamsDto extends ApiCallParamsDto {


    public BankParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 계좌목록
    public HashMap<String, Object> getParamsBank001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 수신계좌 기본
    public HashMap<String, Object> getParamsBank002(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 수신계좌 추가
    public HashMap<String, Object> getParamsBank003(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 수신계좌 거래내역
    public HashMap<String, Object> getParamsBank004(String accountNum, String seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 펀드상품계좌 기본
    public HashMap<String, Object> getParamsBank005(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 펀드상품계좌 추가
    public HashMap<String, Object> getParamsBank006(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 펀드상품계좌 거래내역
    public HashMap<String, Object> getParamsBank007(String accountNum, String seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 대출상품계좌 기본
    public HashMap<String, Object> getParamsBank008(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 대출상품계좌 추가
    public HashMap<String, Object> getParamsBank009(String accountNum, String seqno, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 대출상품계좌 거래내역
    public HashMap<String, Object> getParamsBank010(String accountNum, String seqno, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 신탁/ISA 상품 기본
    public HashMap<String, Object> getParamsBank011(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 신탁/ISA 상품 거래내역
    public HashMap<String, Object> getParamsBank012(String accountNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 신탁/ISA 개별운용상품 기본
    public HashMap<String, Object> getParamsBank013(String accountNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 수신계좌 자동이체 정보
    public HashMap<String, Object> getParamsBank014(String accountNum, Long searchTimeStamp, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
