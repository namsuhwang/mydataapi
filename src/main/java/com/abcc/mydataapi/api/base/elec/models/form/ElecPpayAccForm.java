package com.abcc.mydataapi.api.base.elec.models.form;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayAccEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayAccForm extends FormBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값

    public ElecPpayAccEntity getEntity(){
        ElecPpayAccEntity entity = new ElecPpayAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
