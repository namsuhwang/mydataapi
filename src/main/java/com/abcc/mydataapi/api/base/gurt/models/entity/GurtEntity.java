package com.abcc.mydataapi.api.base.gurt.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String isConsent;    // 전송요구 여부
    private String prodName;    // 상품명
    private String insuType;    // 보험종류 구분(코드)
    private String insuStatus;    // 계약상태 (코드)
}
