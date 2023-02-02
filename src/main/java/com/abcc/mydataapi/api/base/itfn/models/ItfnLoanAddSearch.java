package com.abcc.mydataapi.api.base.itfn.models;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanAddEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanAddForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnLoanAddSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public ItfnLoanAddSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ItfnLoanAddSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public ItfnLoanAddSearch(ItfnLoanAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public ItfnLoanAddSearch(ItfnLoanAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
