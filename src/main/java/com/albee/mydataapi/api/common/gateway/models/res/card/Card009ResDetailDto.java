package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Card009ResDetailDto {

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

    public CardAprOsHistForm getForm(FormBase formBase){
        CardAprOsHistForm form = new CardAprOsHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setApprovedDtime(approvedDtime);
        form.setApprovedNum(approvedNum);
        form.setStatus(status);
        form.setPayType(payType);
        form.setTransDtime(transDtime);
        form.setMerchantName(merchantName);
        form.setApprovedAmt(approvedAmt);
        form.setModifiedAmt(modifiedAmt);
        form.setCountryCode(countryCode);
        form.setCurrencyCode(currencyCode);
        form.setKrwAmt(krwAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
