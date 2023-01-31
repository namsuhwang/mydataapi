package com.kpcnc.mydataapi.api.base.card.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayEntity extends EntityBase {
    private String isRevolving;    // 리볼빙 (여부)
    private Integer payCnt;    // 결제기본정보 목록수
}
