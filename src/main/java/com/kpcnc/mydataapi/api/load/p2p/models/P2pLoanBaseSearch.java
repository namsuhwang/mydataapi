package com.kpcnc.mydataapi.api.load.p2p.models;

import com.kpcnc.mydataapi.api.load.p2p.models.entity.P2pLoanBaseEntity;
import com.kpcnc.mydataapi.api.load.p2p.models.form.P2pLoanBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class P2pLoanBaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String lendingId;    // 대출계약번호

    public P2pLoanBaseSearch(String memberId, String orgCd, String lendingId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.lendingId = lendingId;
    }

    public P2pLoanBaseSearch(P2pLoanBaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.lendingId = entity.getLendingId();
    }

    public P2pLoanBaseSearch(P2pLoanBaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.lendingId = form.getLendingId();
    }
}
