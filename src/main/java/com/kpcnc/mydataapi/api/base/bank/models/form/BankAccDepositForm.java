package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private Integer accountSeq;
    private String currencyCode;    // 통화코드
    private String savingMethod;    // 저축방법
    private String issueDate;    // 계좌개설일자
    private String expDate;    // 만기일
    private BigDecimal commitAmt;    // 약정액
    private BigDecimal monthlyPaidInAmt;    // 월 납입액

    public BankAccDepositForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccDepositEntity getEntity(){
        BankAccDepositEntity entity = new BankAccDepositEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setCurrencyCode(currencyCode);
        entity.setSavingMethod(savingMethod);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setCommitAmt(commitAmt);
        entity.setMonthlyPaidInAmt(monthlyPaidInAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
