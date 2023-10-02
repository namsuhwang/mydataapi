package com.albee.mydataapi.api.base.bank.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundAddEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 잔액
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 투자원금
    private BigDecimal fundNum;    // 보유좌수
}
