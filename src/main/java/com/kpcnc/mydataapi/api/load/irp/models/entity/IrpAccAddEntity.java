package com.kpcnc.mydataapi.api.load.irp.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccAddEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String irpName;    // 개별운용상품명
    private String irpNo;    // 상품가입번호
    private String irpType;    // 상품유형 (코드)
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 납입(투자)원 금
    private BigDecimal fundNum;    // 보유좌수
    private String openDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
