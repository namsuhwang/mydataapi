package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardRvForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardRvSearch extends SearchDto {
    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일

    public CardRvSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardRvSearch(String memberId, String orgCd, String reqDate, String endDate) {
        super(memberId, orgCd);
        this.reqDate = reqDate;
        this.endDate = endDate;
    }

    public CardRvSearch(CardRvEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.reqDate = entity.getReqDate();
        this.endDate = entity.getEndDate();
    }

    public CardRvSearch(CardRvForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.reqDate = form.getReqDate();
        this.endDate = form.getEndDate();
    }
}
