package com.kpcnc.mydataapi.api.load.itfn.models;

import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnLoanSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public ItfnLoanSearch(String memberId, String orgCd, String accountNum, String seqno) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public ItfnLoanSearch(ItfnLoanEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public ItfnLoanSearch(ItfnLoanForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}
