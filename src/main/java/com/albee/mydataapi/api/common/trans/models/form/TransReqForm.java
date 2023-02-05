package com.albee.mydataapi.api.common.trans.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransReqForm extends FormBase {
    private String txId;    // 트랜잭션 ID(전송요구서 ID)
    private String caCode;    // 통합인증기관코드
    private String consentType;    // 전자서명 유형
    private Integer consentLen;    // 전자서명 전송요구 항목 길이
    private String consent;    // 전송요구내역
    private String ci;    // 고객 CI 정보
    private Integer sendReqSignLen;    // 전송요구내역 전자서명 길이
    private String sendReqSign;    // 전송요구내역 전자서명
    private Integer authType;    // 본인확인 이용 여부
    private Integer personInfoSignLen;    // 본인확인 이용 동의 전자서명 길이
    private String personInfoSign;    // 본인확인 이용 동의 전자서명
    private String consentNounce;    // 재전송공격 방지정보 1(consentNonce)
    private String ucpidNounce;    // 재전송공격 방지정보 2(ucpidNonce)
    private String certTxId;    // 인증사업자 트랜잭션 아이디

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
}
