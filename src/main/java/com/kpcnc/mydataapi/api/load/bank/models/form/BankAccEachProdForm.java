package com.kpcnc.mydataapi.api.load.bank.models.form;

import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEachProdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccEachProdForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
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
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAccEachProdEntity getEntity(){
        BankAccEachProdEntity entity = new BankAccEachProdEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
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
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
