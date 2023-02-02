package com.albee.mydataapi.api.base.p2p.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanAddEntity extends EntityBase {
    private String lendingId;    // 대출계약번호
    private Long balanceAmt;    // 대출잔액
    private Integer nextRepayCnt;    // 다음 상환 회차
    private String nextRepayDate;    // 다음 상환일
    private Long principalAmt;    // 예정원금
    private Long intAmt;    // 예정이자
}
