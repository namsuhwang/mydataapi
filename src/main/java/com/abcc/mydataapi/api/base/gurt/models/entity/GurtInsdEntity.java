package com.abcc.mydataapi.api.base.gurt.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
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
