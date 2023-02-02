package com.albee.mydataapi.api.base.dc.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcEntity extends EntityBase {
    private String dcNum;    // 상품관리번호
    private String dcName;    // 상품명
    private String isConsent;    // 전송요구 여부
}
