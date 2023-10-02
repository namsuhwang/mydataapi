package com.albee.mydataapi.api.base.invt.models.form;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccProdBaseDateForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String baseDate;    // 기준일자

    public InvtAccProdBaseDateEntity getEntity(){
        InvtAccProdBaseDateEntity entity = new InvtAccProdBaseDateEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setBaseDate(baseDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
