package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositAddForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank005ResDto extends ResBaseDto {
    private String standardFundCode;

    private String paidInType;   // 납입유형(01 : 임의식, 02 : 적립식, 03 : 거치식)

    private String issueDate;   // 개설일

    private String expDate;   // 만기일

    public BankAccFundForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccFundForm form = new BankAccFundForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setStandardFundCode(standardFundCode);
        form.setPaidInType(paidInType);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
