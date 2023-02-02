package com.abcc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.bank.models.form.BankAutoTransForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
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
public class Bank014ResDetailDto {
    private String scheduledOrgCode;    // 지동이체기관(코드)
    private String scheduledAccountNum;    // 자동이체계좌번호
    private BigDecimal scheduledAmt;    // 자동이체금액
    private String scheduledCycle;    // 자동이체주기
    private String scheduledDate;    // 자동이체주기상세
    private String transMemo;    // 적요

    public BankAutoTransForm getForm(FormBase formBase, String accountNum){
        BankAutoTransForm form = new BankAutoTransForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setScheduledOrgCode(scheduledOrgCode);
        form.setScheduledAccountNum(scheduledAccountNum);
        form.setScheduledAmt(scheduledAmt);
        form.setScheduledCycle(scheduledCycle);
        form.setScheduledDate(scheduledDate);
        form.setTransMemo(transMemo);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
