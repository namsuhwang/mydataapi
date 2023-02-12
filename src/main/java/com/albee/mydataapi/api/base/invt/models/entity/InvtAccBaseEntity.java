package com.albee.mydataapi.api.base.invt.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccBaseEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드
    private BigDecimal withholdingsAmt;    // 예수금
    private BigDecimal creditLoanAmt;    // 신용 융자
    private BigDecimal mortgageAmt;    // 대출금
    private BigDecimal availBalance;    // 출금가능금액
}
