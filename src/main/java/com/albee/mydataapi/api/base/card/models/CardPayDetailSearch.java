package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardPayDetailForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardPayDetailEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardPayDetailSearch extends SearchDto {
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일

    public CardPayDetailSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardPayDetailSearch(String memberId, String orgCd, String seqno, String payDueDate) {
        super(memberId, orgCd);
        this.seqno = seqno;
        this.payDueDate = payDueDate;
    }

    public CardPayDetailSearch(CardPayDetailEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.seqno = entity.getSeqno();
        this.payDueDate = entity.getPayDueDate();
    }

    public CardPayDetailSearch(CardPayDetailForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.seqno = form.getSeqno();
        this.payDueDate = form.getPayDueDate();
    }
}
