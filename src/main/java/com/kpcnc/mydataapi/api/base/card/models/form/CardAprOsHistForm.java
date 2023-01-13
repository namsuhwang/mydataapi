package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardAprOsHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호
    private String status;    // 결제상태 (코드)
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String transDtime;    // 정정 또는 승인취소 일시
    private String merchantName;    // 가맹점명
    private BigDecimal approvedAmt;    // 이용금액
    private BigDecimal modifiedAmt;    // 정정후 금액
    private String countryCode;    // 결제(승인) 국가코드
    private String currencyCode;    // 결제(승인) 시 통화코드
    private Long krwAmt;    // 원화
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardAprOsHistEntity getEntity(){
        CardAprOsHistEntity entity = new CardAprOsHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setApprovedDtime(approvedDtime);
        entity.setApprovedNum(approvedNum);
        entity.setStatus(status);
        entity.setPayType(payType);
        entity.setTransDtime(transDtime);
        entity.setMerchantName(merchantName);
        entity.setApprovedAmt(approvedAmt);
        entity.setModifiedAmt(modifiedAmt);
        entity.setCountryCode(countryCode);
        entity.setCurrencyCode(currencyCode);
        entity.setKrwAmt(krwAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
