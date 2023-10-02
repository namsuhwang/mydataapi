package com.albee.mydataapi.api.base.elec.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayEntity extends EntityBase {
    private String fobId;    // 권면 ID
    private String fobName;    // 권면명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 가입일자
    private Integer limitAmt;    // 권면한도
    private String isCharge;    // 자동충전 등록 여부
    private String isWithdrawable;    // 출금 가능 여부
    private Integer currencyCode;    // 통화코드
    private Integer accountCnt;    // 계정수
}
