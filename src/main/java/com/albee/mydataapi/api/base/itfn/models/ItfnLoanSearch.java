package com.albee.mydataapi.api.base.itfn.models;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ItfnLoanSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public ItfnLoanSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ItfnLoanSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public ItfnLoanSearch(ItfnLoanEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public ItfnLoanSearch(ItfnLoanForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
