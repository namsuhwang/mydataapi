package com.abcc.mydataapi.api.base.bank.models;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccLoanSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public BankAccLoanSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccLoanSearch(BankAccLoanEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public BankAccLoanSearch(BankAccLoanForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
