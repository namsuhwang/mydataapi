package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankCustForm extends FormBase {
    private String regDate;    // 고객생성일

    public BankCustEntity getEntity(){
        BankCustEntity entity = new BankCustEntity();
        entity.setMemberId(this.getMemberId());
        entity.setOrgCd(this.getOrgCd());
        entity.setRegDate(regDate);
        entity.setApiTranDay(this.getApiTranDay());
        entity.setApiTranId(this.getApiTranId());
        entity.setRegUserId(this.getRegUserId());
        entity.setRegDt(this.getRegDt());
        entity.setChgUserId(this.getChgUserId());
        entity.setChgDt(this.getChgDt());
        return entity;
    }

//    @Override
//    public EntityBase getEntityBase(){
//        return super.getEntityBase();
//    }
}
