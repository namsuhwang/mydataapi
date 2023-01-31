package com.kpcnc.mydataapi.api.base.bond.models.form;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondForm extends FormBase {
    private String bondNum;    // 채권번호
    private String isConsent;    // 전송요구여부
    private String bondType;    // 기관분류 (코드)
    private String takeoverDate;    // 채권인수일/ 특수채권편입 일/최초대출 일
    private String initOrgCode;    // 최초 대출기관

    public BondEntity getEntity(){
        BondEntity entity = new BondEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setBondNum(bondNum);
        entity.setIsConsent(isConsent);
        entity.setBondType(bondType);
        entity.setTakeoverDate(takeoverDate);
        entity.setInitOrgCode(initOrgCode);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
