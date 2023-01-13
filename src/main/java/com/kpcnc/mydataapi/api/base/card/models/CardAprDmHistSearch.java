package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprDmHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardAprDmHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호

    public CardAprDmHistSearch(String memberId, String orgCd, String approvedDtime, String approvedNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.approvedDtime = approvedDtime;
        this.approvedNum = approvedNum;
    }

    public CardAprDmHistSearch(CardAprDmHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.approvedDtime = entity.getApprovedDtime();
        this.approvedNum = entity.getApprovedNum();
    }

    public CardAprDmHistSearch(CardAprDmHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.approvedDtime = form.getApprovedDtime();
        this.approvedNum = form.getApprovedNum();
    }
}
