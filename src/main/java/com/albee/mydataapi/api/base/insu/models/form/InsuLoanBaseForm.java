package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanBaseForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String loanStartDate;    // 대출일
    private String loanExpDate;    // 만기일
    private String repayMethod;    // 상환방식(코드)
    private String insuNum;    // 증권번호
    private String repayOrgCode;    // 납입기관(코 드)
    private String repayAccountNum;    // 납입 계좌번호 (자동이체)
    private String repayDate;    // 월상환일

    public InsuLoanBaseEntity getEntity(){
        InsuLoanBaseEntity entity = new InsuLoanBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setLoanStartDate(loanStartDate);
        entity.setLoanExpDate(loanExpDate);
        entity.setRepayMethod(repayMethod);
        entity.setInsuNum(insuNum);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setRepayDate(repayDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
