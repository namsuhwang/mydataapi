package com.kpcnc.mydataapi.api.base.p2p.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanAddEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호
    private Long balanceAmt;    // 대출잔액
    private Integer nextRepayCnt;    // 다음 상환 회차
    private String nextRepayDate;    // 다음 상환일
    private Long principalAmt;    // 예정원금
    private Long intAmt;    // 예정이자
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
