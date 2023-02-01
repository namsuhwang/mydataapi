package com.kpcnc.mydataapi.api.base.itfn.models;

import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnLoanHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호

    public ItfnLoanHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ItfnLoanHistSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public ItfnLoanHistSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public ItfnLoanHistSearch(ItfnLoanHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public ItfnLoanHistSearch(ItfnLoanHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
