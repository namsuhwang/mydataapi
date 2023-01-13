package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardDmPcaSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호

    public CardDmPcaSearch(String memberId, String orgCd, String cardId, String purchaseNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.cardId = cardId;
        this.purchaseNum = purchaseNum;
    }

    public CardDmPcaSearch(CardDmPcaEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.cardId = entity.getCardId();
        this.purchaseNum = entity.getPurchaseNum();
    }

    public CardDmPcaSearch(CardDmPcaForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.cardId = form.getCardId();
        this.purchaseNum = form.getPurchaseNum();
    }
}
