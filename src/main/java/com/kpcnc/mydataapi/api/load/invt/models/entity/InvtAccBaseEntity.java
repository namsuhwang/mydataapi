package com.kpcnc.mydataapi.api.load.invt.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccBaseEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드
    private BigDecimal withholdingsAmt;    // 예수금
    private BigDecimal creditLoanAmt;    // 신용 융자
    private BigDecimal mortgageAmt;    // 대출금
    private BigDecimal availBalance;    // 출금가능금액
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
