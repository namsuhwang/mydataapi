package com.albee.mydataapi.api.common.gateway.models.res.gurt;

import com.albee.mydataapi.api.base.gurt.models.form.GurtForm;
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
public class Gurt001ResDetailDto {

    private String insuNum;    // 증권번호
    private Boolean isConsent;    // 전송요구 여부
    private String prodName;    // 상품명
    private String insuType;    // 보험종류 구분(코드)
    private String insuStatus;    // 계약상태 (코드)

    public GurtForm getForm(FormBase formBase){
        GurtForm form = new GurtForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setProdName(prodName);
        form.setInsuType(insuType);
        form.setInsuStatus(insuStatus);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
