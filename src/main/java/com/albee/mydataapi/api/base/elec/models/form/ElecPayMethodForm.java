package com.albee.mydataapi.api.base.elec.models.form;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPayMethodForm extends FormBase {
    private String subKey;    // Sub key
    private String payOrgCode;    // 결제수단 기관 (코드)
    private String payType;    // 결제수단 식별코드
    private String payId;    // 결제수단 식별키
    private String isPrimary;    // Primary 여부

    public ElecPayMethodEntity getEntity(){
        ElecPayMethodEntity entity = new ElecPayMethodEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setSubKey(subKey);
        entity.setPayOrgCode(payOrgCode);
        entity.setPayType(payType);
        entity.setPayId(payId);
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
