package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardPayEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardPayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardPaySearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드

    public CardPaySearch(String memberId, String orgCd) {
        this.memberId = memberId;
        this.orgCd = orgCd;
    }

    public CardPaySearch(CardPayEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
    }

    public CardPaySearch(CardPayForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
    }
}
