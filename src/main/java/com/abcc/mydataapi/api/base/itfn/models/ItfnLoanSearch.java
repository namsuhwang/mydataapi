package com.abcc.mydataapi.api.base.itfn.models;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
