package com.albee.mydataapi.api.base.insu.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String currencyCode;    // 통화코드(대 출원금상환액 및 이자납입액)
    private BigDecimal loanPaidAmt;    // 대출원금상환 액
    private BigDecimal intPaidAmt;    // 이자납입액
    private Integer intCnt;    // 이자적용수
}
