package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardAprDmHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardAprDmHistSearch extends SearchDto {
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호

    public CardAprDmHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardAprDmHistSearch(String memberId, String orgCd, String approvedDtime, String approvedNum) {
        super(memberId, orgCd);
        this.approvedDtime = approvedDtime;
        this.approvedNum = approvedNum;
    }

    public CardAprDmHistSearch(CardAprDmHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.approvedDtime = entity.getApprovedDtime();
        this.approvedNum = entity.getApprovedNum();
    }

    public CardAprDmHistSearch(CardAprDmHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.approvedDtime = form.getApprovedDtime();
        this.approvedNum = form.getApprovedNum();
    }
}
