package com.kpcnc.mydataapi.api.load.itfn.models;

import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnLoanHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호

    public ItfnLoanHistSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public ItfnLoanHistSearch(ItfnLoanHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public ItfnLoanHistSearch(ItfnLoanHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
