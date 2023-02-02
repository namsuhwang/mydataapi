package com.albee.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.bond.models.form.BondForm;
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
public class Bond001ResDetailDto {

    private String bondNum;    // 채권번호
    private Boolean isConsent;    // 전송요구여부
    private String bondType;    // 기관분류 (코드)
    private String takeoverDate;    // 채권인수일/ 특수채권편입 일/최초대출 일
    private String initOrgCode;    // 최초 대출기관

    public BondForm getForm(FormBase formBase){
        BondForm form = new BondForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setBondNum(bondNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setBondType(bondType);
        form.setTakeoverDate(takeoverDate);
        form.setInitOrgCode(initOrgCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
