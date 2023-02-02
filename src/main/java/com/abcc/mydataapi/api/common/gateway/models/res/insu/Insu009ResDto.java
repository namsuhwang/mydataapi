package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanBaseForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu009ResDto extends ResBaseDto {

    private String loanStartDate;    // 대출일
    private String loanExpDate;    // 만기일
    private String repayMethod;    // 상환방식(코드)
    private String insuNum;    // 증권번호
    private String repayOrgCode;    // 납입기관(코 드)
    private String repayAccountNum;    // 납입 계좌번호 (자동이체)
    private String repayDate;    // 월상환일

    public InsuLoanBaseForm getForm(FormBase formBase, String accountNum){
        InsuLoanBaseForm form = new InsuLoanBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setLoanStartDate(loanStartDate);
        form.setLoanExpDate(loanExpDate);
        form.setRepayMethod(repayMethod);
        form.setInsuNum(insuNum);
        form.setRepayOrgCode(repayOrgCode);
        form.setRepayAccountNum(repayAccountNum);
        form.setRepayDate(repayDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
