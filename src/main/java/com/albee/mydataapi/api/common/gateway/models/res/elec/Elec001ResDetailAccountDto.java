package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAccForm;
import com.albee.mydataapi.common.models.form.FormBase;
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
public class Elec001ResDetailAccountDto {

    private String accountId;    // 계정식별값

    public ElecPpayAccForm getForm(FormBase formBase, String fobId){
        ElecPpayAccForm form = new ElecPpayAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setFobId(fobId);
        form.setAccountId(accountId);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
