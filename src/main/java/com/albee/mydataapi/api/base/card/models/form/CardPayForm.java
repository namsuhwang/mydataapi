package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardPayEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayForm extends FormBase {
    private String isRevolving;    // 리볼빙 (여부)
    private Integer payCnt;    // 결제기본정보 목록수

    public CardPayEntity getEntity(){
        CardPayEntity entity = new CardPayEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setIsRevolving(isRevolving);
        entity.setPayCnt(payCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
