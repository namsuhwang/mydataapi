package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardAprOsHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardAprOsHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호
    private String status;    // 결제상태 (코드)

    public CardAprOsHistSearch(String memberId, String orgCd, String approvedDtime, String approvedNum, String status) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.approvedDtime = approvedDtime;
        this.approvedNum = approvedNum;
        this.status = status;
    }

    public CardAprOsHistSearch(CardAprOsHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.approvedDtime = entity.getApprovedDtime();
        this.approvedNum = entity.getApprovedNum();
        this.status = entity.getStatus();
    }

    public CardAprOsHistSearch(CardAprOsHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.approvedDtime = form.getApprovedDtime();
        this.approvedNum = form.getApprovedNum();
        this.status = form.getStatus();
    }
}
