package com.abcc.mydataapi.api.common.gateway.models.res.dc;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Dc002ResDto extends ResBaseDto {

    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일

    public DcBaseForm getForm(FormBase formBase, String dcNum){
        DcBaseForm form = new DcBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setDcNum(dcNum);
        form.setBalanceAmt(balanceAmt);
        form.setEvalAmt(evalAmt);
        form.setIssueDate(issueDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
