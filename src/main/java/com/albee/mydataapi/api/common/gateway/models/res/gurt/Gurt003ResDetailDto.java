package com.albee.mydataapi.api.common.gateway.models.res.gurt;

import com.albee.mydataapi.api.base.gurt.models.form.GurtForm;
import com.albee.mydataapi.api.base.gurt.models.form.GurtHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Gurt003ResDetailDto {

    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)

    public GurtHistForm getForm(FormBase formBase,String insuNum){
        GurtHistForm form = new GurtHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setPaidInCnt(paidInCnt);
        form.setTransDate(transDate);
        form.setPaidAmt(paidAmt);
        form.setPayMethod(payMethod);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
