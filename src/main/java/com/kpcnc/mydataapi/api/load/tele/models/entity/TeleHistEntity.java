package com.kpcnc.mydataapi.api.load.tele.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleHistEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호
    private String transMonth;    // 납부연월
    private BigDecimal paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
