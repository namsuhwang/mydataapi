package com.kpcnc.mydataapi.api.common.gateway.models.res.irp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Irp002ResDto extends ResBaseDto {

    private BigDecimal accumAmt;    // 계좌잔액

    private BigDecimal evalAmt;    // 계좌평가금액

    private BigDecimal employerAmt;    // 사용자부담금

    private BigDecimal employeeAmt;    // 가입자부담금

    private String issueDate;    // 개설일

    private String firstDepositDate;    // 최초입금일

    private String regDate;    // 최초 제도 가입일

    private String rcvStartDate;    // 연금개시시작(예정)일

    public IrpAccBaseForm getForm(FormBase formBase, String accountNum){
        IrpAccBaseForm form = new IrpAccBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setAccumAmt(accumAmt);
        form.setEvalAmt(evalAmt);
        form.setEmployerAmt(employerAmt);
        form.setIssueDate(issueDate);
        form.setFirstDepositDate(firstDepositDate);
        form.setRegDate(regDate);
        form.setRcvStartDate(rcvStartDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
