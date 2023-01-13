package com.kpcnc.mydataapi.api.base.p2p.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanHistEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호
    private Long transDtime;    // 상환일시
    private Integer repayCnt;    // 상환 회차
    private String repayType;    // 상환유형 (코드)
    private Long transAmt;    // 상환금액
    private Long principalAmt;    // 상환금액 중 원금
    private Long intAmt;    // 상환금액 중 이자
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
