package com.kpcnc.mydataapi.api.base.bank.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private String savingMethod;    // 저축방법
    private String issueDate;    // 계좌개설일자
    private String expDate;    // 만기일
    private BigDecimal commitAmt;    // 약정액
    private BigDecimal monthlyPaidInAmt;    // 월 납입액
}
