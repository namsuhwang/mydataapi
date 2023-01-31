package com.kpcnc.mydataapi.api.base.tele.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleChargeEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String chargeMonth;    // 청구년월
    private BigDecimal chargeAmt;    // 청구금액
    private String chargeDate;    // 납부예정일자
}
