package com.kpcnc.mydataapi.api.base.p2p.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호
    private String isConsent;    // 전송요구 여부
    private String type;    // 상품유형 (코드)
    private BigDecimal lendingAmt;    // 대출계약금액
    private String issueDate;    // 대출일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
