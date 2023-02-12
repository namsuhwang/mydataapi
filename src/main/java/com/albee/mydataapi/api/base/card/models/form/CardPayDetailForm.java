package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayDetailForm extends FormBase {
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일
    private Long payAmt;    // 결제예정금액
    private String lumpSumAmt;    // 일시불
    private String monthlyAmt;    // 할부
    private String loanShortAmt;    // 단기대출(현 금서비스)
    private String revolvingAmt;    // 리볼빙
    private String loanLongAmt;    // 장기대출(카 드론)
    private String etcAmt;    // 연회비 및 기타

    public CardPayDetailEntity getEntity(){
        CardPayDetailEntity entity = new CardPayDetailEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setSeqno(seqno);
        entity.setPayDueDate(payDueDate);
        entity.setPayAmt(payAmt);
        entity.setLumpSumAmt(lumpSumAmt);
        entity.setMonthlyAmt(monthlyAmt);
        entity.setLoanShortAmt(loanShortAmt);
        entity.setRevolvingAmt(revolvingAmt);
        entity.setLoanLongAmt(loanLongAmt);
        entity.setEtcAmt(etcAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
