package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Bank006ResDto extends ResBaseDto {
    private String currencyCode;   // 통화코드

    private BigDecimal balanceAmt;   // 잔액

    private BigDecimal evalAmt;   // 평가금액

    private BigDecimal invPrincipal;   // 투자원금

    private BigDecimal fundNum;   // 보유좌수

    public BankAccFundAddForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccFundAddForm form = new BankAccFundAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setEvalAmt(evalAmt);
        form.setInvPrincipal(invPrincipal);
        form.setFundNum(fundNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
