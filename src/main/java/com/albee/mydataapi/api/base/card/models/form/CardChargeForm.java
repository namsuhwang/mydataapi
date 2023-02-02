package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardChargeForm extends FormBase {
    private String seqno;    // 결제순번
    private Long chargeAmt;    // 월별 청구금액
    private String chargeDay;    // 결제일
    private String chargeMonth;    // 청구년월
    private String paidOutDate;    // 결제년월일

    public CardChargeEntity getEntity(){
        CardChargeEntity entity = new CardChargeEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setSeqno(seqno);
        entity.setChargeAmt(chargeAmt);
        entity.setChargeDay(chargeDay);
        entity.setChargeMonth(chargeMonth);
        entity.setPaidOutDate(paidOutDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
