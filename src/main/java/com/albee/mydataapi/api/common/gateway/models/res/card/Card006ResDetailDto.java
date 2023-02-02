package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Card006ResDetailDto {

    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일
    private Long payAmt;    // 결제예정금액
    private String lumpSumAmt;    // 일시불
    private String monthlyAmt;    // 할부
    private String loanShortAmt;    // 단기대출(현 금서비스)
    private String revolvingAmt;    // 리볼빙
    private String loanLongAmt;    // 장기대출(카 드론)
    private String etcAmt;    // 연회비 및 기타

    public CardPayDetailForm getForm(FormBase formBase){
        CardPayDetailForm form = new CardPayDetailForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setSeqno(seqno);
        form.setPayDueDate(payDueDate);
        form.setPayAmt(payAmt);
        form.setLumpSumAmt(lumpSumAmt);
        form.setMonthlyAmt(monthlyAmt);
        form.setLoanShortAmt(loanShortAmt);
        form.setRevolvingAmt(revolvingAmt);
        form.setLoanLongAmt(loanLongAmt);
        form.setEtcAmt(etcAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
