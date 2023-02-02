package com.abcc.mydataapi.api.base.ppay.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayEntity extends EntityBase {
    private String ppId;    // 선불카드 식별자
    private String ppName;    // 선불카드 상품명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 발급일자
    private Integer limitAmt;    // 액면한도 또는 최대충전한도
}
