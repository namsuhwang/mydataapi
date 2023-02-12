package com.albee.mydataapi.api.common.trans.models.dto;


import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransRequestSpec {
    private String xApiTranId;
    private String serviceId; // 정보수신자가 종합포털에 서비스 등록 시 발급받은 서비스번호 • 기관코드(10자리) + 등록일자(8자리) + 순번(4자리) • 예시) ORG00000001202105200001
    /*
    종합포털이 생성
        ‘RO’_‘정보수신자 기관코드(10)’_‘정보제공자 기관코드(10)’_‘중계기관 기관코드(10)’_‘인증기관기관코드(10)’_’통합인증 요청 시간/전자서명 요청 시간(YYYYMMDDHHMMSS)(14)‘_’일련번호정(12)‘
     */
    private String txId;  // 트랜잭션 ID(전송요구서 ID)
    private String orgCode;  // 통합인증을 수행할 정보제공자 코드(종합포털에 기관 등록시 할당된 코드)
    private String caCode;   // 통합인증기관 코드
    private String consentType;   // 전자서명 유형
    private Integer consentLen;  // 전송요구내역 길이
    private String consent;   // 전송요구내역
    private String username;  // ci
    private Integer passwordLen; // sendReqSignLen. 전송요구내역전자서명 길이
    private String password;   // sendReqSign. 전송요구내역전자서명
    private String authType;   // 본인확인 이용 여부
    private Integer signedPersonInfoSignLen;    // 본인확인 이용동의 전자서명 항목 길이(signedPersonInfoReq의 길이)
    private String signedPersonInfoSign;    // 본인확인 이용동의 전자서명
    private String consentNounce;    // 재전송공격 방지정보 (consentNonce)
    private String ucpidNounce;    // 재전송공격 방지정보 2 (ucpidNonce)
    private String certTxId;    // 인증사업자 트랜잭션 아이디

    private Integer sendReqSeq;   // 전송요구일련번호. MEMBER_TOKEN 테이블의 SEND_REQ_SEQ. 내부적으로 토큰 정보 구분을 위한 일련번호. 전송요구 수정시에 필수 입력
    private String requestType;   // 전송요구타입. 자산목록조회 전송요구(1차) : 0 (전송요구내역의 scope에 xxx.list만 존재하는 경우), 고객선택자산에 대한 세부 전송요구(2차) : 1

    @JsonIgnore
    private MemberEntity member;

    @JsonIgnore
    private MemberTokenEntity token;

    public TransReqForm getTransReqForm(){
        TransReqForm form = new TransReqForm();
        form.setTxId(txId);
        form.setOrgCd(orgCode);
        form.setCaCode(caCode);
        form.setConsentLen(consentLen);
        form.setConsent(consent);
        form.setCi(username);
        form.setSendReqSignLen(passwordLen);
        form.setSendReqSign(password);
        form.setAuthType(authType);
        form.setPersonInfoSignLen(signedPersonInfoSignLen);
        form.setPersonInfoSign(signedPersonInfoSign);
        form.setConsentNounce(consentNounce);
        form.setUcpidNounce(ucpidNounce);
        form.setCertTxId(certTxId);
        form.setSendReqSeq(sendReqSeq);
        form.setRequestType(requestType);
        return form;
    }

}
