package com.albee.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiHistForm;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Insu021ResDetailDto {

    private String transDate;    // 납입일자
    private Integer transAppliedMonth;    // 납입연월
    private Integer paidInCnt;    // 납입회차
    private BigDecimal paidAmt;    // 실납입 보험료
    private String currencyCode;    // 통화코드(실 납입 보험료)
    private String payMethod;    // 수금방법 (코드)

    public InsuMiHistForm getForm(FormBase formBase, String insuNum){
        InsuMiHistForm form = new InsuMiHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setTransDate(transDate);
        form.setTransAppliedMonth(transAppliedMonth);
        form.setPaidInCnt(paidInCnt);
        form.setPaidAmt(paidAmt);
        form.setCurrencyCode(currencyCode);
        form.setPayMethod(payMethod);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
