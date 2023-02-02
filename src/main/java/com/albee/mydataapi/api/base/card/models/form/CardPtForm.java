package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.base.card.models.entity.CardPtEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPtForm extends FormBase {
    private String pointName;    // 포인트명
    private Long remainPointAmt;    // 잔여포인트
    private Long expiringPointAmt;    // M+2월 소멸예정 포인트

    public CardPtEntity getEntity(){
        CardPtEntity entity = new CardPtEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setPointName(pointName);
        entity.setRemainPointAmt(remainPointAmt);
        entity.setExpiringPointAmt(expiringPointAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
