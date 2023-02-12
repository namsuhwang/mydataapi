package com.albee.mydataapi.api.common.trans.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestConsent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransReqEntity extends EntityBase {
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

    public TransRequestConsent getTransRequestConsent(){
        TransRequestConsent trc = (new ObjectMapper()).convertValue(consent, TransRequestConsent.class);
        return trc;
    }

}
