package com.abcc.mydataapi.api.base.card.models;

import com.abcc.mydataapi.api.base.card.models.form.CardPayForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.card.models.entity.CardPayEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardPaySearch extends SearchDto {

    public CardPaySearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardPaySearch(CardPayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
    }

    public CardPaySearch(CardPayForm form) {
        super(form.getMemberId(), form.getOrgCd());
    }
}
