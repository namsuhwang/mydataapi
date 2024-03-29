package com.albee.mydataapi.api.base.irp.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부
}
