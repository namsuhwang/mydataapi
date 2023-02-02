package com.abcc.mydataapi.api.base.p2p.models;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.abcc.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class P2pLoanAddSearch extends SearchDto {
    private String lendingId;    // 대출계약번호

    public P2pLoanAddSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public P2pLoanAddSearch(String memberId, String orgCd, String lendingId) {
        super(memberId, orgCd);
        this.lendingId = lendingId;
    }

    public P2pLoanAddSearch(P2pLoanAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.lendingId = entity.getLendingId();
    }

    public P2pLoanAddSearch(P2pLoanAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.lendingId = form.getLendingId();
    }
}
