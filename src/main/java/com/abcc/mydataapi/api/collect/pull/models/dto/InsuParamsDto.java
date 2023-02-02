package com.abcc.mydataapi.api.collect.pull.models.dto;

import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class InsuParamsDto extends ApiCallParamsDto {

    public InsuParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 보험 목록
    public HashMap<String, Object> getParamsInsu001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 보험 기본정보
    public HashMap<String, Object> getParamsInsu002(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 보험 특약 정보
    public HashMap<String, Object> getParamsInsu003(String insuNum, String insuredNo, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("insured_no", insuredNo);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 자동차보험 정보
    public HashMap<String, Object> getParamsInsu004(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 보험 납입 정보
    public HashMap<String, Object> getParamsInsu005(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 보험 거래내역
    public HashMap<String, Object> getParamsInsu006(String insuNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 자동차보험 거래내역
    public HashMap<String, Object> getParamsInsu007(String insuNum, String carNumber, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("car_number", carNumber);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 대출상품 목록
    public HashMap<String, Object> getParamsInsu008(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 대출 기본정보
    public HashMap<String, Object> getParamsInsu009(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 대출 추가정보
    public HashMap<String, Object> getParamsInsu010(String accountNum, Long searchTimeStamp){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 대출상품 거래내역
    public HashMap<String, Object> getParamsInsu011(String accountNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("account_num", accountNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 보험 보장정보
    public HashMap<String, Object> getParamsInsu012(String insuNum,Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 보험 목록
    public HashMap<String, Object> getParamsInsu013(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 피보험자 기본정보
    public HashMap<String, Object> getParamsInsu014(String insuNum,Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 보험특약
    public HashMap<String, Object> getParamsInsu015(String insuNum,Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 자동차보험 정보
    public HashMap<String, Object> getParamsInsu016(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 보험 보장정보
    public HashMap<String, Object> getParamsInsu017(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 물, 일반보험 기본정보
    public HashMap<String, Object> getParamsInsu018(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 물, 일반보험 특약정보
    public HashMap<String, Object> getParamsInsu019(String insuNum, String insuredNo, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("insured_no", insuredNo);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 물, 일반보험 납입정보
    public HashMap<String, Object> getParamsInsu020(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 물, 일반보험 거래내역
    public HashMap<String, Object> getParamsInsu021(String insuNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 피보험자 물, 일반보험 기본정보
    public HashMap<String, Object> getParamsInsu022(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 물, 일반보험 특약정보
    public HashMap<String, Object> getParamsInsu023(String insuNum, String insuredNo, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("insured_no", insuredNo);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 물, 일반 보장정보
    public HashMap<String, Object> getParamsInsu024(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 피보험자 물, 일반 보장정보
    public HashMap<String, Object> getParamsInsu025(String insuNum, Long searchTimeStamp){
        this.paramsMap.put("insu_num", insuNum);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }
}
