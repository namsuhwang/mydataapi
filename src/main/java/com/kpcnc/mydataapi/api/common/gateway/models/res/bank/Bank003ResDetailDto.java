package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank003ResDetailDto {

    private Integer accountSeq;
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;  // 현재잔액. F (18, 3)
    private BigDecimal withdrawableAmt; // 출금 가능액. F (18, 3)
    private Double offeredRate; // 금리. F (7, 5)
    private Integer lastPaidInCnt;  // 최종납입회차

    public BankAccDepositAddForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccDepositAddForm form = new BankAccDepositAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setAccountSeq(accountSeq);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setWithdrawableAmt(withdrawableAmt);
        form.setOfferedRate(offeredRate);
        form.setLastPaidInCnt(lastPaidInCnt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
