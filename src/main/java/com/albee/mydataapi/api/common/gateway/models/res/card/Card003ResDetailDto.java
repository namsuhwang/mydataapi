package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.albee.mydataapi.api.base.card.models.form.CardPtForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Card003ResDetailDto {

    private String pointName;    // 포인트명
    private Long remainPointAmt;    // 잔여포인트
    private Long expiringPointAmt;    // M+2월 소멸예정 포인트

    public CardPtForm getForm(FormBase formBase){
        CardPtForm form = new CardPtForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setPointName(pointName);
        form.setRemainPointAmt(remainPointAmt);
        form.setExpiringPointAmt(expiringPointAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
