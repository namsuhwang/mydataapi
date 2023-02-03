package com.albee.mydataapi.api.common.gateway.models.res.tele;

import com.albee.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
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
public class Tele002ResDetailDto {

    private String chargeMonth;    // 청구년월
    private Long chargeAmt;    // 청구금액
    private String chargeDate;    // 납부예정일자

    public TeleChargeForm getForm(FormBase formBase, String mgmtId){
        TeleChargeForm form = new TeleChargeForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setMgmtId(mgmtId);
        form.setChargeMonth(chargeMonth);
        form.setChargeAmt(chargeAmt);
        form.setChargeDate(chargeDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
