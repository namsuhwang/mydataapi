package com.kpcnc.mydataapi.api.load.card.models;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardBaseEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardBaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자

    public CardBaseSearch(String memberId, String orgCd, String cardId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.cardId = cardId;
    }

    public CardBaseSearch(CardBaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.cardId = entity.getCardId();
    }

    public CardBaseSearch(CardBaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.cardId = form.getCardId();
    }
}
