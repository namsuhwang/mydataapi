package com.kpcnc.mydataapi.api.load.bank.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private String savingMethod;    // 저축방법
    private String issueDate;    // 계좌개설일자
    private String expDate;    // 만기일
    private BigDecimal commitAmt;    // 약정액
    private BigDecimal monthlyPaidInAmt;    // 월 납입액
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
