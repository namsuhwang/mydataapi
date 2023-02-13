package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardAprOsHistSearch extends SearchDto {
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호
    private String status;    // 결제상태 (코드)

    public CardAprOsHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);

    }

    public CardAprOsHistSearch(String memberId, String orgCd, String approvedDtime, String approvedNum, String status) {
        super(memberId, orgCd);
        this.approvedDtime = approvedDtime;
        this.approvedNum = approvedNum;
        this.status = status;
    }

    public CardAprOsHistSearch(CardAprOsHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.approvedDtime = entity.getApprovedDtime();
        this.approvedNum = entity.getApprovedNum();
        this.status = entity.getStatus();
    }

    public CardAprOsHistSearch(CardAprOsHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.approvedDtime = form.getApprovedDtime();
        this.approvedNum = form.getApprovedNum();
        this.status = form.getStatus();
    }
}
