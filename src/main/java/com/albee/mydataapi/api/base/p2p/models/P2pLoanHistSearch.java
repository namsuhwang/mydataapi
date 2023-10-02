package com.albee.mydataapi.api.base.p2p.models;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class P2pLoanHistSearch extends SearchDto {
    private String lendingId;    // 대출계약번호

    public P2pLoanHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public P2pLoanHistSearch(String memberId, String orgCd, String lendingId) {
        super(memberId, orgCd);
        this.lendingId = lendingId;
    }

    public P2pLoanHistSearch(P2pLoanHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.lendingId = entity.getLendingId();
    }

    public P2pLoanHistSearch(P2pLoanHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.lendingId = form.getLendingId();
    }
}
