package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardChargeAddSearch extends SearchDto {
    private String seqno;    // 결제순번
    private String chargeMonth;    // 청구년월
    private String cardId;    // 카드 식별자
    private String paidDtime;    // 사용일시 또는 사용일자
    private String transNo;    // 거래번호

    public CardChargeAddSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardChargeAddSearch(String memberId, String orgCd, String seqno, String chargeMonth, String cardId, String paidDtime, String transNo) {
        super(memberId, orgCd);
        this.seqno = seqno;
        this.chargeMonth = chargeMonth;
        this.cardId = cardId;
        this.paidDtime = paidDtime;
        this.transNo = transNo;
    }

    public CardChargeAddSearch(CardChargeAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.seqno = entity.getSeqno();
        this.chargeMonth = entity.getChargeMonth();
        this.cardId = entity.getCardId();
        this.paidDtime = entity.getPaidDtime();
        this.transNo = entity.getTransNo();
    }

    public CardChargeAddSearch(CardChargeAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.seqno = form.getSeqno();
        this.chargeMonth = form.getChargeMonth();
        this.cardId = form.getCardId();
        this.paidDtime = form.getPaidDtime();
        this.transNo = form.getTransNo();
    }
}
