package com.kpcnc.mydataapi.api.base.gurt.models.form;

import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtInsdForm extends FormBase {
    private String insuNum;    // 증권번호
    private String insuredName;    // 피보험자명

    public GurtInsdEntity getEntity(){
        GurtInsdEntity entity = new GurtInsdEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setInsuredName(insuredName);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
