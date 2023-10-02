package com.albee.mydataapi.api.base.tele.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleChargeEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String chargeMonth;    // 청구년월
    private Long chargeAmt;    // 청구금액
    private String chargeDate;    // 납부예정일자
}
