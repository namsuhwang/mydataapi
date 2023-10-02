package com.albee.mydataapi.api.base.elec.models.form;

import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecAccForm extends FormBase {
    private String subKey;    // Sub key
    private String accountId;    // 계정식별값
    private String isConsent;    // 전송요구여부
    private String regDate;    // 가입일
    private String isPay;    // 결제수단 등록 여부

    public ElecAccEntity getEntity(){
        ElecAccEntity entity = new ElecAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setSubKey(subKey);
        entity.setAccountId(accountId);
        entity.setIsConsent(isConsent);
        entity.setRegDate(regDate);
        entity.setIsPay(isPay);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
