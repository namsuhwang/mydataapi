package com.albee.mydataapi.api.base.p2p.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanEntity extends EntityBase {
    private String lendingId;    // 대출계약번호
    private String isConsent;    // 전송요구 여부
    private String type;    // 상품유형 (코드)
    private BigDecimal lendingAmt;    // 대출계약금액
    private String issueDate;    // 대출일
}
