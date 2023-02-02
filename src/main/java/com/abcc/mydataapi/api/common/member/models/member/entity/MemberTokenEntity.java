package com.abcc.mydataapi.api.common.member.models.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberTokenEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private Integer sendReqSeq;    // 전송요구 일련번호
    private String idstType;    // 업권 유형
    private String scopeList;    // 권한범위 목록
    private List<String> scopeLists;
    private String sendRequestType;    // 전송요청 유형
    private String fpSendReqYn;    // 정기전송 요청 여부
    private String fpSendReqDt;    // 정기전송 요구 일시
    private String fpSendReqStartDay;    // 정기전송 요구 시작일자
    private String fpSendReqEndDay;    // 정기전송 요구 종료일자
    private String fpCycl;    // 정기전송 주기
    private String accessToken;    // 접근 토큰
    private Long accessTokenExpireIn;    // 접근 토큰 유효기간
    private String accessTokenIssueDt;    // 접근 토큰 발급 일시
    private String accessTokenDueDt;    // 접근 토큰 만료 일시
    private String accessTokenExpireYn;    // 접근 토큰 폐기 여부
    private String accessTokenExpireDt;    // 접근 토큰 폐기 일시
    private String represhToken;    // 리프레시 토큰
    private Long represhTokenExpireIn;    // 리프레시 토큰 유효기간
    private String represhTokenIssueDt;    // 리프레시 토큰 발급 일시
    private String represhTokenDueDt;    // 리프레시 토큰 만료 일시
    private String represhTokenExpireYn;    // 리프레시 토큰 폐기 여부
    private String represhTokenExpireDt;    // 리프레시 토큰 폐기 일시
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
