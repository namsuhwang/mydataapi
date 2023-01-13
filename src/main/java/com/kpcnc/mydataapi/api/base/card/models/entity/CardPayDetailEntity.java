package com.kpcnc.mydataapi.api.base.card.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayDetailEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일
    private Long payAmt;    // 결제예정금액
    private String lumpSumAmt;    // 일시불
    private String monthlyAmt;    // 할부
    private String loanShortAmt;    // 단기대출(현 금서비스)
    private String revolvingAmt;    // 리볼빙
    private String loanLongAmt;    // 장기대출(카 드론)
    private String etcAmt;    // 연회비 및 기타
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
