package com.abcc.mydataapi.api.base.bond.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondBalEntity extends EntityBase {
    private String bondNum;    // 채권번호
    private String prevOrgCode;    // 직전 채권인계기관
    private String isDebtMgmt;    // 채무조정 여부
    private String repayMethod;    // 상환방식 (코드)
    private Long balanceAmt;    // 대출잔액
    private Long bondPrincipal;    // 대출원금
}
