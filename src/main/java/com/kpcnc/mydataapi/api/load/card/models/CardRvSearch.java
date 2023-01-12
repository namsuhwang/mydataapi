package com.kpcnc.mydataapi.api.load.card.models;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardRvForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardRvSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일

    public CardRvSearch(String memberId, String orgCd, String reqDate, String endDate) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.reqDate = reqDate;
        this.endDate = endDate;
    }

    public CardRvSearch(CardRvEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.reqDate = entity.getReqDate();
        this.endDate = entity.getEndDate();
    }

    public CardRvSearch(CardRvForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.reqDate = form.getReqDate();
        this.endDate = form.getEndDate();
    }
}
