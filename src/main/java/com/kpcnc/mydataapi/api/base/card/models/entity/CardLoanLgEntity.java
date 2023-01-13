package com.kpcnc.mydataapi.api.base.card.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanLgEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanNum;    // 대출번호
    private String loanDtime;    // 대출일시 또는 대출일자
    private Integer loanCnt;    // 일자의 대출회차
    private String loanType;    // 대출종류
    private String loanName;    // 상품명
    private BigDecimal loanAmt;    // 이용금액
    private Float intRate;    // 이자율
    private String expDate;    // 만기일
    private BigDecimal balanceAmt;    // 장기대출 잔액
    private String repayMethod;    // 상환방법 (코드)
    private BigDecimal intAmt;    // 상환액 중 이자
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
