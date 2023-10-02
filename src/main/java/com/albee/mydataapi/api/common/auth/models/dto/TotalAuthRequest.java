package com.albee.mydataapi.api.common.auth.models.dto;


import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

/*
    통합인증-002. 전문의 입력항목 정의.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TotalAuthRequest {
    private String serviceId; // 정보수신자가 종합포털에 서비스 등록 시 발급받은 서비스번호 • 기관코드(10자리) + 등록일자(8자리) + 순번(4자리) • 예시) ORG00000001202105200001
    /*
        마이데이터 사업자가 생성
        ‘MD’_‘마이데이터사업자기관코드(10)’_‘정보제공자 기관코드(10)’_‘중계기관 기관코드(10)’_‘인증기관 기관코드(10)’_’통합인증 요청 시간/전자서명 요청 시간(YYYYMMDDHHMMSS)(14)‘_’일련번호(12)‘
     */
    private String txId;  // 트랜잭션 ID(마이데이터사업자가 생성)
    private String orgCode;  // 통합인증을 수행할 정보제공자 코드(종합포털에 기관 등록시 할당된 코드)
    private String grantType;   // 권한부여방식. "password"로 고정
    @Value("${mydata.client.id}")
    private String clientId;   // 클라이언트ID. 종합포털에 마이데이터 서비스 등록 시 발급받은 클라이언트 식별값
    @Value("${mydata.client.secret}")
    private String clientSecret;   // 클라이언트 Secret. 종합포털에 마이데이터 서비스 등록 시 발급받은 클라이언트 Secret 값(보안을 강화하기 위해 추가 확인하기 위한 코드)
    private String caCode;   // 통합인증기관 코드
    private String username;  // ci
    private String requestType;   // 전송요구타입. 자산목록조회 전송요구(1차) : 0 (전송요구내역의 scope에 xxx.list만 존재하는 경우), 고객선택자산에 대한 세부 전송요구(2차) : 1
    private Integer passwordLen; // sendReqSignLen. 전송요구내역전자서명 길이
    private String password;   // sendReqSign. 전송요구내역전자서명
    private String authType;   // 본인확인 이용 여부
    private String consentType;   // 전자서명 유형
    private Integer consentLen;  // 전송요구내역 길이
    private String consent;   // 전송요구내역
    private Integer signedPersonInfoSignLen;    // 본인확인 이용동의 전자서명 항목 길이(signedPersonInfoReq의 길이)
    private String signedPersonInfoSign;    // 본인확인 이용동의 전자서명
    private String consentNounce;    // 재전송공격 방지정보 (consentNonce)
    private String ucpidNounce;    // 재전송공격 방지정보 2 (ucpidNonce)
    private String certTxId;    // 인증사업자 트랜잭션 아이디

    public TotalAuthRequest(TransRequestSpec dom) {
        this.serviceId = dom.getServiceId();
        this.orgCode = dom.getOrgCode();
        this.grantType = "password";
        this.caCode = dom.getCaCode();
        this.username = dom.getUsername();
        this.requestType = dom.getRequestType();
        this.passwordLen = dom.getPasswordLen();
        this.password = dom.getPassword();
        this.authType = dom.getAuthType();
        this.consentType = dom.getConsentType();
        this.consentLen = dom.getConsentLen();
        this.consent = dom.getConsent();
        this.signedPersonInfoSignLen = dom.getSignedPersonInfoSignLen();
        this.signedPersonInfoSign = dom.getSignedPersonInfoSign();
        this.consentNounce = dom.getConsentNounce();
        this.ucpidNounce = dom.getUcpidNounce();
        this.certTxId = dom.getCertTxId();
    }
}
