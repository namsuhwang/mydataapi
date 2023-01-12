package com.kpcnc.mydataapi.api.load.card.models;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardOsPcaEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardOsPcaForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardOsPcaSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호

    public CardOsPcaSearch(String memberId, String orgCd, String cardId, String purchaseNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.cardId = cardId;
        this.purchaseNum = purchaseNum;
    }

    public CardOsPcaSearch(CardOsPcaEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.cardId = entity.getCardId();
        this.purchaseNum = entity.getPurchaseNum();
    }

    public CardOsPcaSearch(CardOsPcaForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.cardId = form.getCardId();
        this.purchaseNum = form.getPurchaseNum();
    }
}
