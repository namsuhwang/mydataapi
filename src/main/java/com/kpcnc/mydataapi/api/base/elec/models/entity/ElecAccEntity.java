package com.kpcnc.mydataapi.api.base.elec.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecAccEntity extends EntityBase {
    private String subKey;    // Sub key
    private String accountId;    // 계정식별값
    private String isConsent;    // 전송요구여부
    private String regDate;    // 가입일
    private String isPay;    // 결제수단 등록 여부
}
