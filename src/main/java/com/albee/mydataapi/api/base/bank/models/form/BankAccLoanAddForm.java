package com.albee.mydataapi.api.base.bank.models.form;

import com.albee.mydataapi.api.base.bank.models.entity.BankAccLoanAddEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccLoanAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 대출잔액
    private BigDecimal loanPrincipal;    // 대출원금
    private String nextRepayDate;    // 다음 이자 상환일

    public BankAccLoanAddForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccLoanAddEntity getEntity(){
        BankAccLoanAddEntity entity = new BankAccLoanAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setLoanPrincipal(loanPrincipal);
        entity.setNextRepayDate(nextRepayDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
