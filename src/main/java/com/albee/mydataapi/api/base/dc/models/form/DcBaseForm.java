package com.albee.mydataapi.api.base.dc.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcBaseForm extends FormBase {
    private String dcNum;    // 상품관리번호
    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일

    public DcBaseEntity getEntity(){
        DcBaseEntity entity = new DcBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setDcNum(dcNum);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setIssueDate(issueDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
