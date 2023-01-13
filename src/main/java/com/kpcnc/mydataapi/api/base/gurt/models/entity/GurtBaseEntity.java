package com.kpcnc.mydataapi.api.base.gurt.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtBaseEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String issueDate;    // 계약체결일
    private String expDate;    // 종료일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String payDue;    // 납입기간구분(코드)
    private BigDecimal payAmt;    // 총 납입 보험료
    private Integer insuredCnt;    // 피보험자수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
