package com.albee.mydataapi.api.base.p2p.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanBaseEntity extends EntityBase {
    private String lendingId;    // 대출계약번호
    private String expDate;    // 만기일
    private Float offeredRate;    // 대출금리
    private String repayMethod;    // 상환방식 (코드)
    private Float ltvRate;    // 부동산담보 LTV 비율
}
