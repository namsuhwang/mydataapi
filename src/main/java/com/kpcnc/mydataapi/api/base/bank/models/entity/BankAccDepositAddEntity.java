package com.kpcnc.mydataapi.api.base.bank.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositAddEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private Integer accountSeq;
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 현재잔액
    private BigDecimal withdrawableAmt;    // 출금 가능액
    private Double offeredRate;    // 금리
    private Integer lastPaidInCnt;    // 최종납입회차
}
