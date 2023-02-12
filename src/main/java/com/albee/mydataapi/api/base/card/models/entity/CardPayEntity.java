package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
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
