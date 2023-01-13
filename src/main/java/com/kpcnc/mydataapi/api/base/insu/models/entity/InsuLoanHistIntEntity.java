package com.kpcnc.mydataapi.api.base.insu.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistIntEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String intStartDate;    // 이자적용시작 일
    private String intEndDate;    // 이자적용종료 일
    private Float intRate;    // 적용이율
    private String intType;    // 이자종류 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
