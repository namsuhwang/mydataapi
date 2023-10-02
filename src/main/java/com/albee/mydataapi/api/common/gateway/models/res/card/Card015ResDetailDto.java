package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardOsPcaForm;
import com.albee.mydataapi.common.models.form.FormBase;
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
public class Card015ResDetailDto {

    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호
    private String purchaseDate;    // 매입일자
    private String salesDate;    // 매출일자
    private String priApprovedNum;    // 원승인번호
    private String priApprovedDtime;    // 원승인일시
    private BigDecimal priApprovedAmt;    // 원승인금액
    private Long priKrwAmt;    // 원승인금액 원화
    private String priCurrencyCode;    // 원승인금액 통화코드
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String merchantName;    // 가맹점명
    private BigDecimal approvedAmt;    // 이용금액
    private String countryCode;    // 결제(매입) 국가코드
    private String currencyCode;    // 결제(매입) 시 통화코드
    private Long krwAmt;    // 원화

    public CardOsPcaForm getForm(FormBase formBase){
        CardOsPcaForm form = new CardOsPcaForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setCardId(cardId);
        form.setPurchaseNum(purchaseNum);
        form.setPurchaseDate(purchaseDate);
        form.setSalesDate(salesDate);
        form.setPriApprovedNum(priApprovedNum);
        form.setPriApprovedDtime(priApprovedDtime);
        form.setPriApprovedAmt(priApprovedAmt);
        form.setPriKrwAmt(priKrwAmt);
        form.setPriCurrencyCode(priCurrencyCode);
        form.setPayType(payType);
        form.setMerchantName(merchantName);
        form.setApprovedAmt(approvedAmt);
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
