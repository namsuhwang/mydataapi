package com.abcc.mydataapi.api.common.gateway.models.res.bank;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
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
public class Bank002ResDetailDto {

    private Integer accountSeq;
    private String currencyCode;    // 통화코드
    private String savingMethod;
    private String issueDate;
    private String expDate;
    private BigDecimal commitAmt;
    private BigDecimal monthlyPaidInAmt;

    public BankAccDepositForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccDepositForm form = new BankAccDepositForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setAccountSeq(accountSeq);
        form.setCurrencyCode(currencyCode);
        form.setSavingMethod(savingMethod);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setCommitAmt(commitAmt);
        form.setMonthlyPaidInAmt(monthlyPaidInAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
