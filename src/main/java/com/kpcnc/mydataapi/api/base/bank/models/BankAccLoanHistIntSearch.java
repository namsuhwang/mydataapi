package com.kpcnc.mydataapi.api.base.bank.models;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccLoanHistIntSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private String intStartDate;    // 이자적용시작일
    private String intEndDate;    // 이자적용종료일

    public BankAccLoanHistIntSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo, String transType, String intStartDate, String intEndDate) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
        this.transType = transType;
        this.intStartDate = intStartDate;
        this.intEndDate = intEndDate;
    }

    public BankAccLoanHistIntSearch(BankAccLoanHistIntEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
        this.transType = entity.getTransType();
        this.intStartDate = entity.getIntStartDate();
        this.intEndDate = entity.getIntEndDate();
    }

    public BankAccLoanHistIntSearch(BankAccLoanHistIntForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
        this.transType = form.getTransType();
        this.intStartDate = form.getIntStartDate();
        this.intEndDate = form.getIntEndDate();
    }
}