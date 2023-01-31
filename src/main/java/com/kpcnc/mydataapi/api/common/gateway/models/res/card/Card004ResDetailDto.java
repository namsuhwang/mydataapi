package com.kpcnc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.kpcnc.mydataapi.api.base.card.models.form.CardForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card004ResDetailDto {

    private String seqno;    // 결제순번
    private Long chargeAmt;    // 월별 청구금액
    private String chargeDay;    // 결제일
    private String chargeMonth;    // 청구년월
    private String paidOutDate;    // 결제년월일

    public CardChargeForm getForm(FormBase formBase){
        CardChargeForm form = new CardChargeForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setSeqno(seqno);
        form.setChargeAmt(chargeAmt);
        form.setChargeDay(chargeDay);
        form.setChargeMonth(chargeMonth);
        form.setPaidOutDate(paidOutDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
