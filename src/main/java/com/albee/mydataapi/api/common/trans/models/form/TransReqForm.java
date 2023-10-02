package com.albee.mydataapi.api.common.trans.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestConsent;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransReqForm extends FormBase {
    private String xApiTranId;
    private String txId;    // 트랜잭션 ID(전송요구서 ID)
    private String caCode;    // 통합인증기관코드
    private String consentType;    // 전자서명 유형
    private Integer consentLen;    // 전자서명 전송요구 항목 길이
    private String consent;    // 전송요구내역
    private String ci;    // 고객 CI 정보
    private Integer sendReqSignLen;    // 전송요구내역 전자서명 길이
    private String sendReqSign;    // 전송요구내역 전자서명
    private String authType;    // 본인확인 이용 여부
    private Integer personInfoSignLen;    // 본인확인 이용 동의 전자서명 길이
    private String personInfoSign;    // 본인확인 이용 동의 전자서명
    private String consentNounce;    // 재전송공격 방지정보 1(consentNonce)
    private String ucpidNounce;    // 재전송공격 방지정보 2(ucpidNonce)
    private String certTxId;    // 인증사업자 트랜잭션 아이디

    private Integer sendReqSeq;   // 전송요구일련번호. MEMBER_TOKEN 테이블의 SEND_REQ_SEQ. 내부적으로 토큰 정보 구분을 위한 일련번호. 전송요구 수정시에 필수 입력
    private String requestType;   // 전송요구타입. 자산목록조회 전송요구(1차) : 0 (전송요구내역의 scope에 xxx.list만 존재하는 경우), 고객선택자산에 대한 세부 전송요구(2차) : 1

    public TransReqEntity getEntity(){
        TransReqEntity entity = new TransReqEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setTxId(txId);
        entity.setCaCode(caCode);
        entity.setConsentType(consentType);
        entity.setConsentLen(consentLen);
        entity.setConsent(consent);
        entity.setCi(ci);
        entity.setSendReqSignLen(sendReqSignLen);
        entity.setSendReqSign(sendReqSign);
        entity.setAuthType(authType);
        entity.setPersonInfoSignLen(personInfoSignLen);
        entity.setPersonInfoSign(personInfoSign);
        entity.setConsentNounce(consentNounce);
        entity.setUcpidNounce(ucpidNounce);
        entity.setCertTxId(certTxId);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }


    public TransRequestConsent getTransRequestConsent(){
        TransRequestConsent trc = (new ObjectMapper()).convertValue(consent, TransRequestConsent.class);
        return trc;
    }
}
