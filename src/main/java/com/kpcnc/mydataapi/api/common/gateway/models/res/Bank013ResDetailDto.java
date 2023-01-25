package com.kpcnc.mydataapi.api.common.gateway.models.res;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdHistForm;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank013ResDetailDto {
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호
    private String prodType;    // 상품유형(코드)
    private String currencyCode;    // 통화코드
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal principalAmt;    // 납입(투자)원금
    private BigDecimal holdingNum;    // 보유좌수
    private String issueDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율

    public BankAccEachProdForm getForm(FormBase formBase, String accountNum){
        BankAccEachProdForm form = new BankAccEachProdForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setProdName(prodName);
        form.setProdNum(prodNum);
        form.setProdType(prodType);
        form.setCurrencyCode(currencyCode);
        form.setEvalAmt(evalAmt);
        form.setPrincipalAmt(principalAmt);
        form.setHoldingNum(holdingNum);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setIntRate(intRate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
