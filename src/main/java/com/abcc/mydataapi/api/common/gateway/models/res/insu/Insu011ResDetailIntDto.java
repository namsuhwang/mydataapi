package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanHistIntForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu011ResDetailIntDto {

    private String intStartDate;    // 이자적용시작 일
    private String intEndDate;    // 이자적용종료 일
    private Float intRate;    // 적용이율
    private String intType;    // 이자종류 (코드)

    public InsuLoanHistIntForm getForm(FormBase formBase, String accountNum, String transNo, String transDtime){
        InsuLoanHistIntForm form = new InsuLoanHistIntForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setTransNo(transNo);
        form.setTransDtime(transDtime);
        form.setIntStartDate(intStartDate);
        form.setIntEndDate(intEndDate);
        form.setIntRate(intRate);
        form.setIntType(intType);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
