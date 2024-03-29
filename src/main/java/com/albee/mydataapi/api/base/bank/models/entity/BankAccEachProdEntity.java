package com.albee.mydataapi.api.base.bank.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccEachProdEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호
    private String prodType;    // 상품유형 (코드)
    private String currencyCode;    // 통화코드
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal principalAmt;    // 납입(투자)원금
    private BigDecimal holdingNum;    // 보유좌수
    private String issueDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율
}
