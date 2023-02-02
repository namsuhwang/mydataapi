package com.albee.mydataapi.api.base.bank.models;

import com.albee.mydataapi.api.base.bank.models.form.BankAccForm;
import com.albee.mydataapi.api.base.bank.models.entity.BankAccEntity;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BankAccSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;

    public BankAccSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccSearch(BankAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public BankAccSearch(BankAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
