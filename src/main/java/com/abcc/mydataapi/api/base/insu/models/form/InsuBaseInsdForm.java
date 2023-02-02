package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuBaseInsdForm extends FormBase {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호
    private String insuredName;    // 피보험자명
    private String isPrimary;    // 주피보험자 여부

    public InsuBaseInsdEntity getEntity(){
        InsuBaseInsdEntity entity = new InsuBaseInsdEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setInsuredNo(insuredNo);
        entity.setInsuredName(insuredName);
        entity.setIsPrimary(isPrimary);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
