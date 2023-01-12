package com.kpcnc.mydataapi.api.load.card.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanStEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanDtime;    // 이용일시
    private Long loanAmt;    // 이용금액(취급액)
    private Long balanceAmt;    // 단기대출 잔액
    private String payDueDate;    // 결제예정일
    private Float intRate;    // 이자율
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
