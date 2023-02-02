package com.abcc.mydataapi.api.base.p2p.models;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanEntity;
import com.abcc.mydataapi.api.base.p2p.models.form.P2pLoanForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class P2pLoanSearch extends SearchDto {
    private String lendingId;    // 대출계약번호

    public P2pLoanSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public P2pLoanSearch(String memberId, String orgCd, String lendingId) {
        super(memberId, orgCd);
        this.lendingId = lendingId;
    }

    public P2pLoanSearch(P2pLoanEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.lendingId = entity.getLendingId();
    }

    public P2pLoanSearch(P2pLoanForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.lendingId = form.getLendingId();
    }
}
