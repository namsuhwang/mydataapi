package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardPayDetailSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일

    public CardPayDetailSearch(String memberId, String orgCd, String seqno, String payDueDate) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.seqno = seqno;
        this.payDueDate = payDueDate;
    }

    public CardPayDetailSearch(CardPayDetailEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.seqno = entity.getSeqno();
        this.payDueDate = entity.getPayDueDate();
    }

    public CardPayDetailSearch(CardPayDetailForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.seqno = form.getSeqno();
        this.payDueDate = form.getPayDueDate();
    }
}
