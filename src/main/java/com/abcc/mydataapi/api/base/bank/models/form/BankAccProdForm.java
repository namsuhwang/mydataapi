package com.abcc.mydataapi.api.base.bank.models.form;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccProdForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일
    private String expDate;    // 만기일

    public BankAccProdForm(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAccProdEntity getEntity(){
        BankAccProdEntity entity = new BankAccProdEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
