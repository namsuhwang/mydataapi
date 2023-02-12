package com.albee.mydataapi.api.base.invt.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtPensionAccAddEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String issueDate;    // 연금가입일
    private BigDecimal paidInAmt;    // 납부총액
    private BigDecimal withdrawalAmt;    // 기출금액
    private String lastPaidInDate;    // 최종납입일
    private BigDecimal rcvAmt;    // 연금기수령액
    private String pensionRcvStartDate;    // 연금개시(예정)일
    private BigDecimal annualPayAmount;    // 금년납입금
    private String currencyCode;    // 통화코드
}
