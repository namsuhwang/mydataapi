package com.albee.mydataapi.api.base.gurt.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtInsdEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String insuredName;    // 피보험자명
}
