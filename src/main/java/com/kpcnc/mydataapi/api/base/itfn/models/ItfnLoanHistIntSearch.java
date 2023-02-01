package com.kpcnc.mydataapi.api.base.itfn.models;

import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ItfnLoanHistIntSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호
    private String intStartDate;    // 이자적용시작일
    private String intEndDate;    // 이자적용종료일

    public ItfnLoanHistIntSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo, String intStartDate, String intEndDate) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
        this.intStartDate = intStartDate;
        this.intEndDate = intEndDate;
    }

    public ItfnLoanHistIntSearch(ItfnLoanHistIntEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
        this.intStartDate = entity.getIntStartDate();
        this.intEndDate = entity.getIntEndDate();
    }

    public ItfnLoanHistIntSearch(ItfnLoanHistIntForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
        this.intStartDate = form.getIntStartDate();
        this.intEndDate = form.getIntEndDate();
    }
}
