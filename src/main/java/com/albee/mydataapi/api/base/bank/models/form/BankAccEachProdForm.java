package com.albee.mydataapi.api.base.bank.models.form;

import com.albee.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccEachProdForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호
    private String prodType;    // 상품유형 (코드)
    private String currencyCode;    // 통화코드
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal principalAmt;    // 납입(투자)원금
    private BigDecimal holdingNum;    // 보유좌수
    private String issueDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율

    public BankAccEachProdEntity getEntity(){
        BankAccEachProdEntity entity = new BankAccEachProdEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setProdName(prodName);
        entity.setProdNum(prodNum);
        entity.setProdType(prodType);
        entity.setCurrencyCode(currencyCode);
        entity.setEvalAmt(evalAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setHoldingNum(holdingNum);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setIntRate(intRate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
