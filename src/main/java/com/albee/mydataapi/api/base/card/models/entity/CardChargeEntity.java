package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardChargeEntity extends EntityBase {
    private String seqno;    // 결제순번
    private Long chargeAmt;    // 월별 청구금액
    private String chargeDay;    // 결제일
    private String chargeMonth;    // 청구년월
    private String paidOutDate;    // 결제년월일
}
