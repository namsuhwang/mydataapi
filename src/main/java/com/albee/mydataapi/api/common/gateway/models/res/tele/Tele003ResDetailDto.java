package com.albee.mydataapi.api.common.gateway.models.res.tele;

import com.albee.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.albee.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class Tele003ResDetailDto {

    private String transMonth;    // 납부연월
    private Long paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)

    public TeleHistForm getForm(FormBase formBase, String mgmtId){
        TeleHistForm form = new TeleHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setMgmtId(mgmtId);
        form.setTransMonth(transMonth);
        form.setPaidAmt(paidAmt);
        form.setPayMethod(payMethod);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
