package com.albee.mydataapi.api.base.bond.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondHistEntity extends EntityBase {
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private Long transAmt;    // 거래금액
    private Long balanceAmt;    // 거래 후 대출잔액
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal principalAmt;    // 거래금액 중 원금
}
