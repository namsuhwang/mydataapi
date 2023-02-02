package com.abcc.mydataapi.api.collect.pull.models.dto;

import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallParamsDto;

import java.util.HashMap;

public class CardParamsDto extends ApiCallParamsDto {

    public CardParamsDto(HashMap<String, Object> baseParamsMap) {
        super(baseParamsMap);
    }

    // 카드 목록
    public HashMap<String, Object> getParamsCard001(Long searchTimeStamp, String nextPage){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 카드 기본정보
    public HashMap<String, Object> getParamsCard002(String cardId, Long searchTimeStamp){
        this.paramsMap.put("card_id", cardId);
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 포인트 정보
    public HashMap<String, Object> getParamsCard003(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 청구 기본정보
    public HashMap<String, Object> getParamsCard004(String fromMonth, String toMonth, String nextPage){
        this.paramsMap.put("from_month", fromMonth);
        this.paramsMap.put("to_month", toMonth);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 청구 추가정보
    public HashMap<String, Object> getParamsCard005(String seqno, String chargeMonth, String nextPage){
        this.paramsMap.put("seqno", seqno);
        this.paramsMap.put("charge_month", chargeMonth);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 카드 결제 정보
    public HashMap<String, Object> getParamsCard006(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 카드 리볼빙 정보
    public HashMap<String, Object> getParamsCard007(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 국내 승인내역
    public HashMap<String, Object> getParamsCard008(String fromDate, String toDate, String nextPage){
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 해외 승인내역
    public HashMap<String, Object> getParamsCard009(String fromDate, String toDate, String nextPage){
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 대출상품 목록
    public HashMap<String, Object> getParamsCard010(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 단기대출 정보
    public HashMap<String, Object> getParamsCard011(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 장기대출 정보
    public HashMap<String, Object> getParamsCard012(Long searchTimeStamp){
        this.paramsMap.put("search_time_stamp", searchTimeStamp);
        return this.paramsMap;
    }

    // 장기대출 거래내역
    public HashMap<String, Object> getParamsCard013(String loanNum, String fromDate, String toDate, String nextPage){
        this.paramsMap.put("loan_num", loanNum);
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 국내카드 매입(매입취소)정보
    public HashMap<String, Object> getParamsCard014(String fromDate, String toDate, String nextPage){
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }

    // 해외카드 매입(매입취소)정보
    public HashMap<String, Object> getParamsCard015(String fromDate, String toDate, String nextPage){
        this.paramsMap.put("from_date", fromDate);
        this.paramsMap.put("to_date", toDate);
        this.paramsMap.put("next_page", nextPage);
        this.paramsMap.put("limit", 500);
        return this.paramsMap;
    }
}
