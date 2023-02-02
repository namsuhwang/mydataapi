package com.abcc.mydataapi.api.base.card.models;

import com.abcc.mydataapi.api.base.card.models.form.CardBaseForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardBaseSearch extends SearchDto {
    private String cardId;    // 카드 식별자

    public CardBaseSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardBaseSearch(String memberId, String orgCd, String cardId) {
        super(memberId, orgCd);
        this.cardId = cardId;
    }

    public CardBaseSearch(CardBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.cardId = entity.getCardId();
    }

    public CardBaseSearch(CardBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.cardId = form.getCardId();
    }
}
