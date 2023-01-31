package com.kpcnc.mydataapi.api.base.p2p.models;

import com.kpcnc.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import com.kpcnc.mydataapi.api.base.p2p.models.form.P2pLoanBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class P2pLoanBaseSearch extends SearchDto {
    private String lendingId;    // 대출계약번호

    public P2pLoanBaseSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public P2pLoanBaseSearch(String memberId, String orgCd, String lendingId) {
        super(memberId, orgCd);
        this.lendingId = lendingId;
    }

    public P2pLoanBaseSearch(P2pLoanBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.lendingId = entity.getLendingId();
    }

    public P2pLoanBaseSearch(P2pLoanBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.lendingId = form.getLendingId();
    }
}
