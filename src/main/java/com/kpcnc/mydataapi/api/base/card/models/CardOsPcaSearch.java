package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardOsPcaForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardOsPcaSearch extends SearchDto {
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호

    public CardOsPcaSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardOsPcaSearch(String memberId, String orgCd, String cardId, String purchaseNum) {
        super(memberId, orgCd);
        this.cardId = cardId;
        this.purchaseNum = purchaseNum;
    }

    public CardOsPcaSearch(CardOsPcaEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.cardId = entity.getCardId();
        this.purchaseNum = entity.getPurchaseNum();
    }

    public CardOsPcaSearch(CardOsPcaForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.cardId = form.getCardId();
        this.purchaseNum = form.getPurchaseNum();
    }
}
