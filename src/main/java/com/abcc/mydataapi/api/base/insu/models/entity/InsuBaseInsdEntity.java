package com.abcc.mydataapi.api.base.insu.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuBaseInsdEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호
    private String insuredName;    // 피보험자명
    private String isPrimary;    // 주피보험자 여부
}
