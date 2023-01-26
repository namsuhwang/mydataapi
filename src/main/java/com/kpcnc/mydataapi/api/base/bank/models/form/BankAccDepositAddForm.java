package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositAddEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private Integer accountSeq;
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 현재잔액
    private BigDecimal withdrawableAmt;    // 출금 가능액
    private Double offeredRate;    // 금리
    private Integer lastPaidInCnt;    // 최종납입회차

    public BankAccDepositAddEntity getEntity(){
        BankAccDepositAddEntity entity = new BankAccDepositAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setAccountSeq(accountSeq);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setWithdrawableAmt(withdrawableAmt);
        entity.setOfferedRate(offeredRate);
        entity.setLastPaidInCnt(lastPaidInCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
