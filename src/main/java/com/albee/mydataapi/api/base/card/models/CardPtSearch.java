package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardPtEntity;
import com.albee.mydataapi.api.base.card.models.form.CardPtForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardPtSearch extends SearchDto {
    private String pointName;    // 포인트명

    public CardPtSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardPtSearch(String memberId, String orgCd, String pointName) {
        super(memberId, orgCd);
        this.pointName = pointName;
    }

    public CardPtSearch(CardPtEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.pointName = entity.getPointName();
    }

    public CardPtSearch(CardPtForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.pointName = form.getPointName();
    }
}
