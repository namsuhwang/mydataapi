package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardOsPcaForm extends FormBase {
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

    public CardOsPcaEntity getEntity(){
        CardOsPcaEntity entity = new CardOsPcaEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setCardId(cardId);
        entity.setPurchaseNum(purchaseNum);
        entity.setPurchaseDate(purchaseDate);
        entity.setSalesDate(salesDate);
        entity.setPriApprovedNum(priApprovedNum);
        entity.setPriApprovedDtime(priApprovedDtime);
        entity.setPriApprovedAmt(priApprovedAmt);
        entity.setPriKrwAmt(priKrwAmt);
        entity.setPriCurrencyCode(priCurrencyCode);
        entity.setPayType(payType);
        entity.setMerchantName(merchantName);
        entity.setApprovedAmt(approvedAmt);
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
