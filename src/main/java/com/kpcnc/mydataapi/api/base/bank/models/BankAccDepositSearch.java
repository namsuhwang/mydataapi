package com.kpcnc.mydataapi.api.base.bank.models;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccDepositForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccDepositSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public BankAccDepositSearch(String memberId, String orgCd, String accountNum, String seqno) {
        this.setMemberId(memberId);
        this.setOrgCd(orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccDepositSearch(BankAccDepositEntity entity) {
        this.setMemberId(entity.getMemberId());
        this.setOrgCd(entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public BankAccDepositSearch(BankAccDepositForm form) {
        this.setMemberId(form.getMemberId());
        this.setOrgCd(form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
