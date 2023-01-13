package com.kpcnc.mydataapi.api.base.bond.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondHistEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transAmt;    // 거래금액
    private Long balanceAmt;    // 거래 후 대출잔액
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자

    private String chgDt;    // 수정일시
}
