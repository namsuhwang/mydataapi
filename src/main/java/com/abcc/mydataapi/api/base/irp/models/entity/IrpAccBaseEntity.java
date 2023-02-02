package com.abcc.mydataapi.api.base.irp.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccBaseEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private BigDecimal accumAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private BigDecimal employerAmt;    // 사용자부담금
    private BigDecimal employeeAmt;    // 가입자부담금
    private String issueDate;    // 개설일
    private String firstDepositDate;    // 최초입금일
    private String regDate;    // 최초 제도 가입일
    private String rcvStartDate;    // 연금개시 시작(예정)일
}
