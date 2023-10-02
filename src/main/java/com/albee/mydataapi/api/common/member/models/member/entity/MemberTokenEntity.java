package com.albee.mydataapi.api.common.member.models.member.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberTokenEntity extends EntityBase {
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
    private String holdEndDay;    // 개인신용정보 보유 종료일자
    private String memoTransYn;    // 적요 전송 여부
    private String accessToken;    // 접근 토큰
    private Long accessTokenExpireIn;    // 접근 토큰 유효기간
    private String accessTokenIssueDt;    // 접근 토큰 발급 일시
    private String accessTokenDueDt;    // 접근 토큰 만료 일시
    private String accessTokenExpireYn;    // 접근 토큰 폐기 여부
    private String accessTokenExpireDt;    // 접근 토큰 폐기 일시
    private String refreshToken;    // 리프레시 토큰
    private Long refreshTokenExpireIn;    // 리프레시 토큰 유효기간
    private String refreshTokenIssueDt;    // 리프레시 토큰 발급 일시
    private String refreshTokenDueDt;    // 리프레시 토큰 만료 일시
    private String refreshTokenExpireYn;    // 리프레시 토큰 폐기 여부
    private String refreshTokenExpireDt;    // 리프레시 토큰 폐기 일시
}
