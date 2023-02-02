package com.abcc.mydataapi.api.base.elec.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayAutoChargeEntity extends EntityBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)
    private String chargeAccountNum;    // 충전지불수단 식별키
    private String chargeOption;    // 충전조건 (코드)
    private String chargeDay;    // 기준날짜
    private BigDecimal chargeBaseAmt;    // 기준금액
    private BigDecimal chargeAmt;    // 충전금액
}
