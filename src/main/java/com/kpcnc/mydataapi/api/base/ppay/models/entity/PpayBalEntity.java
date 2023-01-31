package com.kpcnc.mydataapi.api.base.ppay.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayBalEntity extends EntityBase {
    private String ppId;    // 선불카드 식별자
    private String totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정
}
