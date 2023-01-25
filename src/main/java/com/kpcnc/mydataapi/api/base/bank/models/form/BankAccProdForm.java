package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
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
public class BankAccProdForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일
    private String expDate;    // 만기일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAccProdForm(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAccProdEntity getEntity(){
        BankAccProdEntity entity = new BankAccProdEntity();
        entity.setMemberId(this.getMemberId());
        entity.setOrgCd(this.getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
