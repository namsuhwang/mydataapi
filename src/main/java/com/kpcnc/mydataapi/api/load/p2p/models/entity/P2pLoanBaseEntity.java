package com.kpcnc.mydataapi.api.load.p2p.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanBaseEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호
    private String expDate;    // 만기일
    private Float offeredRate;    // 대출금리
    private String repayMethod;    // 상환방식 (코드)
    private Float ltvRate;    // 부동산담보 LTV 비율
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
