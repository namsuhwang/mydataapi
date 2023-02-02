package com.abcc.mydataapi.api.base.itfn.models.form;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnCustEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnCustForm extends FormBase {
    private String regDate;    // 최초고객DB 생성일

    public ItfnCustEntity getEntity(){
        ItfnCustEntity entity = new ItfnCustEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setRegDate(regDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
