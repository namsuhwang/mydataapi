package com.abcc.mydataapi.api.base.bank.models;

import com.abcc.mydataapi.api.base.bank.models.form.BankAccFundHistForm;
import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundHistEntity;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccFundHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형 (코드)

    public BankAccFundHistSearch(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccFundHistSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public BankAccFundHistSearch(String memberId, String orgCd, String accountNum, String seqno, String transDtime, String transNo, String transType) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.transDtime = transDtime;
        this.transNo = transNo;
        this.transType = transType;
    }

    public BankAccFundHistSearch(BankAccFundHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
        this.transType = entity.getTransType();
    }

    public BankAccFundHistSearch(BankAccFundHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
        this.transType = form.getTransType();
    }
}
