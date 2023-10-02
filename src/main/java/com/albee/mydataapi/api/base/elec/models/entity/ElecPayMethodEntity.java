package com.albee.mydataapi.api.base.elec.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPayMethodEntity extends EntityBase {
    private String subKey;    // Sub key
    private String payOrgCode;    // 결제수단 기관 (코드)
    private String payType;    // 결제수단 식별코드
    private String payId;    // 결제수단 식별키
    private String isPrimary;    // Primary 여부
}