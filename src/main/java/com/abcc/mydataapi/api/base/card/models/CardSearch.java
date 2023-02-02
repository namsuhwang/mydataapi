package com.abcc.mydataapi.api.base.card.models;

import com.abcc.mydataapi.api.base.card.models.form.CardForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.card.models.entity.CardEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardSearch extends SearchDto {
    private String cardId;    // 카드 식별자

    public CardSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardSearch(String memberId, String orgCd, String cardId) {
        super(memberId, orgCd);
        this.cardId = cardId;
    }

    public CardSearch(CardEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.cardId = entity.getCardId();
    }

    public CardSearch(CardForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.cardId = form.getCardId();
    }
}
