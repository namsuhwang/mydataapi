package com.kpcnc.mydataapi.api.base.irp.models.form;

import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccBaseForm extends FormBase {
    private String accountNum;    // 계좌번호
    private BigDecimal accumAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private BigDecimal employerAmt;    // 사용자부담금
    private BigDecimal employeeAmt;    // 가입자부담금
    private String issueDate;    // 개설일
    private String firstDepositDate;    // 최초입금일
    private String regDate;    // 최초 제도 가입일
    private String rcvStartDate;    // 연금개시 시작(예정)일

    public IrpAccBaseEntity getEntity(){
        IrpAccBaseEntity entity = new IrpAccBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setAccumAmt(accumAmt);
        entity.setEvalAmt(evalAmt);
        entity.setEmployerAmt(employerAmt);
        entity.setEmployeeAmt(employeeAmt);
        entity.setIssueDate(issueDate);
        entity.setFirstDepositDate(firstDepositDate);
        entity.setRegDate(regDate);
        entity.setRcvStartDate(rcvStartDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
