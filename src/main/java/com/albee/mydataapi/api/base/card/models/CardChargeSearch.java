package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardChargeForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardChargeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardChargeSearch extends SearchDto {
    private String seqno;    // 결제순번

    public CardChargeSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardChargeSearch(String memberId, String orgCd, String seqno) {
        super(memberId, orgCd);
        this.seqno = seqno;
    }

    public CardChargeSearch(CardChargeEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.seqno = entity.getSeqno();
    }

    public CardChargeSearch(CardChargeForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.seqno = form.getSeqno();
    }
}
