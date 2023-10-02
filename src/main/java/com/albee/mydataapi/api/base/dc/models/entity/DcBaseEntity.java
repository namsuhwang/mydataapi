package com.albee.mydataapi.api.base.dc.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcBaseEntity extends EntityBase {
    private String dcNum;    // 상품관리번호
    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일
}
