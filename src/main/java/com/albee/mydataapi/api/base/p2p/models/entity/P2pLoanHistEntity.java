package com.albee.mydataapi.api.base.p2p.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanHistEntity extends EntityBase {
    private String lendingId;    // 대출계약번호
    private Long transDtime;    // 상환일시
    private Integer repayCnt;    // 상환 회차
    private String repayType;    // 상환유형 (코드)
    private Long transAmt;    // 상환금액
    private Long principalAmt;    // 상환금액 중 원금
    private Long intAmt;    // 상환금액 중 이자
}
