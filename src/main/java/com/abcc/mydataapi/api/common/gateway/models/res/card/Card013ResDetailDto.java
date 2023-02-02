package com.abcc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgHistForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card013ResDetailDto {

    private String loanNum;    // 대출번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 대출잔액
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private BigDecimal intAmt;    // 거래금액 중 이자

    public CardLoanLgHistForm getForm(FormBase formBase){
        CardLoanLgHistForm form = new CardLoanLgHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLoanNum(loanNum);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransType(transType);
        form.setCurrencyCode(currencyCode);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setPrincipalAmt(principalAmt);
        form.setIntAmt(intAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
