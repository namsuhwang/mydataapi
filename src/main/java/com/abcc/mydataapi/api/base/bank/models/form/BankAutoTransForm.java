package com.abcc.mydataapi.api.base.bank.models.form;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAutoTransForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String scheduledOrgCode;    // 지동이체 기관(코드)
    private String scheduledAccountNum;    // 자동이체계좌 번호
    private BigDecimal scheduledAmt;    // 자동이체금액
    private String scheduledCycle;    // 자동이체주기
    private String scheduledDate;    // 자동이체주기 상세
    private String transMemo;    // 적요

    public BankAutoTransForm(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAutoTransEntity getEntity(){
        BankAutoTransEntity entity = new BankAutoTransEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setScheduledOrgCode(scheduledOrgCode);
        entity.setScheduledAccountNum(scheduledAccountNum);
        entity.setScheduledAmt(scheduledAmt);
        entity.setScheduledCycle(scheduledCycle);
        entity.setScheduledDate(scheduledDate);
        entity.setTransMemo(transMemo);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
