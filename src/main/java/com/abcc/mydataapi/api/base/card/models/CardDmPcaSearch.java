package com.abcc.mydataapi.api.base.card.models;

import com.abcc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardDmPcaSearch extends SearchDto {
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호

    public CardDmPcaSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardDmPcaSearch(String memberId, String orgCd, String cardId, String purchaseNum) {
        super(memberId, orgCd);
        this.cardId = cardId;
        this.purchaseNum = purchaseNum;
    }

    public CardDmPcaSearch(CardDmPcaEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.cardId = entity.getCardId();
        this.purchaseNum = entity.getPurchaseNum();
    }

    public CardDmPcaSearch(CardDmPcaForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.cardId = form.getCardId();
        this.purchaseNum = form.getPurchaseNum();
    }
}
