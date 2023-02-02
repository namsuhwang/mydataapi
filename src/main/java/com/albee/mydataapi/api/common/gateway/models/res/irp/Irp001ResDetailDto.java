package com.albee.mydataapi.api.common.gateway.models.res.irp;

import com.albee.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Irp001ResDetailDto {

    private String prodName;    // 상품명
    private String accountNum;    // 계좌번호
    private Boolean isConsent;    // 전송요구 여부

    public IrpAccForm getForm(FormBase formBase){
        IrpAccForm form = new IrpAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setProdName(prodName);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
