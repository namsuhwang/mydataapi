package com.kpcnc.mydataapi.api.base.card.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanLgHistEntity extends EntityBase {
    private String loanNum;    // 대출번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 대출잔액
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private BigDecimal intAmt;    // 거래금액 중 이자
}
