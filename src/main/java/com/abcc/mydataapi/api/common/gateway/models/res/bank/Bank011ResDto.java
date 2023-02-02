package com.abcc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccProdForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank011ResDto extends ResBaseDto {

    private String currencyCode;    // 통화코드

    private BigDecimal balanceAmt;    // 계좌잔액

    private BigDecimal evalAmt;    // 계좌평가금액

    private String issueDate;   // 개설일

    private String expDate;   // 만기일


    public BankAccProdForm getForm(FormBase formBase, String accountNum){
        BankAccProdForm form = new BankAccProdForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setEvalAmt(evalAmt);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
