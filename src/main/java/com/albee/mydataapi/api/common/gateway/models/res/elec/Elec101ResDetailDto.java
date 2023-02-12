package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecAccForm;
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
public class Elec101ResDetailDto {

    private String subKey;    // Sub key
    private String accountId;    // 계정식별값
    private Boolean isConsent;    // 전송요구여부
    private String regDate;    // 가입일
    private Boolean isPay;    // 결제수단 등록 여부

    public ElecAccForm getForm(FormBase formBase){
        ElecAccForm form = new ElecAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setSubKey(subKey);
        form.setAccountId(accountId);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setRegDate(regDate);
        form.setIsPay(isPay ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
