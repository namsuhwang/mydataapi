package com.kpcnc.mydataapi.api.common.gateway.models.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

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
