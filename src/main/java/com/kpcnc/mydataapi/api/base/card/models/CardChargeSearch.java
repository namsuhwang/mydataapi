package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardChargeEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardChargeSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번

    public CardChargeSearch(String memberId, String orgCd, String seqno) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.seqno = seqno;
    }

    public CardChargeSearch(CardChargeEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.seqno = entity.getSeqno();
    }

    public CardChargeSearch(CardChargeForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.seqno = form.getSeqno();
    }
}
