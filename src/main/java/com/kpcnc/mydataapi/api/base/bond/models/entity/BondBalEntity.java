package com.kpcnc.mydataapi.api.base.bond.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondBalEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호
    private String prevOrgCode;    // 직전 채권인계기관
    private String isDebtMgmt;    // 채무조정 여부
    private String repayMethod;    // 상환방식 (코드)
    private Long balanceAmt;    // 대출잔액
    private Long bondPrincipal;    // 대출원금
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
