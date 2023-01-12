package com.kpcnc.mydataapi.api.load.card.models;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardChargeAddEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardChargeAddSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번
    private String chargeMonth;    // 청구년월
    private String cardId;    // 카드 식별자
    private String paidDtime;    // 사용일시 또는 사용일자
    private String transNo;    // 거래번호

    public CardChargeAddSearch(String memberId, String orgCd, String seqno, String chargeMonth, String cardId, String paidDtime, String transNo) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.seqno = seqno;
        this.chargeMonth = chargeMonth;
        this.cardId = cardId;
        this.paidDtime = paidDtime;
        this.transNo = transNo;
    }

    public CardChargeAddSearch(CardChargeAddEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.seqno = entity.getSeqno();
        this.chargeMonth = entity.getChargeMonth();
        this.cardId = entity.getCardId();
        this.paidDtime = entity.getPaidDtime();
        this.transNo = entity.getTransNo();
    }

    public CardChargeAddSearch(CardChargeAddForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.seqno = form.getSeqno();
        this.chargeMonth = form.getChargeMonth();
        this.cardId = form.getCardId();
        this.paidDtime = form.getPaidDtime();
        this.transNo = form.getTransNo();
    }
}
