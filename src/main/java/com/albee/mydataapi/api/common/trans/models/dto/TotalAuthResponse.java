package com.albee.mydataapi.api.common.trans.models.dto;


import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/*
    통합인증-002. 전문의 입력항목 정의.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TotalAuthResponse {
    private String xApiTranId;
    /*
        마이데이터 사업자가 생성
        ‘MD’_‘마이데이터사업자기관코드(10)’_‘정보제공자 기관코드(10)’_‘중계기관 기관코드(10)’_‘인증기관 기관코드(10)’_’통합인증 요청 시간/전자서명 요청 시간(YYYYMMDDHHMMSS)(14)‘_’일련번호(12)‘
     */
    private String txId;  // 트랜잭션 ID(마이데이터사업자가 생성)
    private String tokenType;  // 접근토큰 유형. "Bearer"로 고정
    private String accessToken;   // 발급된 접근토큰
    private Long expiresIn;   // 접근토큰 유효기간(단위:초)
    private String refreshToken;   // 리프레시 토큰. 접근토큰 갱신을 위한 토큰
    private Long refreshTokenExpiresIn;   // 리프레시 토큰 유효기간(단위:초)
    private String scope;  // 권한범위. scope 리스트. 접근토큰 권한범위(다중 scope 가능). 예:“card.list card.card card.point card.loan”
}
