package com.kpcnc.mydataapi.api.base.itfn.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLoanHistEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 대출잔액
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal retIntAmt;    // 환출이자
    private Integer intCnt;    // 이자적용수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}