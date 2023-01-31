package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.card.models.form.CardForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu001ResDetailDto {

    private String insuNum;    // 증권번호
    private Boolean isConsent;    // 전송요구 여부
    private String prodName;    // 상품명
    private String insuType;    // 보험종류 구분 (코드)
    private String insuStatus;    // 계약상태 (코드)

    public InsuForm getForm(FormBase formBase){
        InsuForm form = new InsuForm();
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
