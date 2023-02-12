package com.albee.mydataapi.api.common.gateway.models.res.bank;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.bank.models.form.BankAccFundForm;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
