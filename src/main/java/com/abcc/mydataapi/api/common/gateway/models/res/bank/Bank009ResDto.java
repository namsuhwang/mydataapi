package com.abcc.mydataapi.api.common.gateway.models.res.bank;

import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanAddForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class Bank009ResDto extends ResBaseDto {
    private String currencyCode;   // 통화코드

    private BigDecimal balanceAmt;   // 대출잔액

    private BigDecimal loanPrincipal;    // 대출원금

    private String nextRepayDate;    // 다음 이자 상환일



    public BankAccLoanAddForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccLoanAddForm form = new BankAccLoanAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setLoanPrincipal(loanPrincipal);
        form.setNextRepayDate(nextRepayDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
