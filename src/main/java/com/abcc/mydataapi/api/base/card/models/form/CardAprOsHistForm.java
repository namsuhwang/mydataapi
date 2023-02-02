package com.abcc.mydataapi.api.base.card.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardAprOsHistForm extends FormBase {
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

    public CardAprOsHistEntity getEntity(){
        CardAprOsHistEntity entity = new CardAprOsHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
