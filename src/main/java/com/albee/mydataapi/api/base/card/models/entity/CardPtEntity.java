package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPtEntity extends EntityBase {
    private String pointName;    // 포인트명
    private Long remainPointAmt;    // 잔여포인트
    private Long expiringPointAmt;    // M+2월 소멸예정 포인트
}
