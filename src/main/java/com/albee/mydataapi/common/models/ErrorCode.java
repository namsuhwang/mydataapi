package com.albee.mydataapi.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    AUTHENTICATION_ENTRY_POINT_EXCEPTION(401,"AuthenticationEntryPointException","AuthenticationEntryPointException"),
    FORBIDDEN_EXCEPTION(403, "ForbiddenException", "Access Deniend"),
    NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
    UNAUTHORIZED_EXCEPTION(401,"0001","인증 실패"),
    UNMATCHED_AUTH_INFO_EXCEPTION(400,"0002","이메일 또는 비밀번호 확인 실패"),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
    EMAIL_DUPLICATION(400,"MEMBER-ERR-400","EMAIL DUPLICATED"),
    NULL_RF_TOKEN(400,"0002","리프레쉬 토큰이 입력되지 않았습니다."),
    NOT_EXIST_RF_TOKEN(400,"0003","일치하는 리프레쉬 토큰이 없습니다."),


    MYDATA_ERROR_1000(400,"1000","DB 에러"),
    MYDATA_ERROR_1001(400,"1001","존재하지 않는 회원입니다."),
    MYDATA_ERROR_1002(400,"1002","유효한 전송요구 내역이 없습니다."),
    MYDATA_ERROR_1003(400,"1003","주식 종목을 먼저 등록하십시오."),
    MYDATA_ERROR_1004(400,"1004","거래내역 등록 필수입력 항목(거래종류, 종목코드, 거래수량, 거래단가)을 확인하십시오."),
    MYDATA_ERROR_1005(400,"1005","매도수량이 보유수량보다 많습니다."),
    MYDATA_ERROR_1006(400,"1006","이메일주소 확인이 필요합니다. 회원 미가입이면 신규가입 바랍니다."),
    MYDATA_ERROR_1007(400,"1007","다른 사람이 사용중인 이메일주소입니다."),
    MYDATA_ERROR_1008(400,"1008","이미 등록되어 있는 관심 종목입니다."),
    ;

    private int status;
    private String errorCode;
    private String message;

}