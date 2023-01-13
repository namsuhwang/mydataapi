package com.kpcnc.mydataapi.api.base.bank.models;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccFundSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String standardFundCode;    // 표준펀드코드
    private String paidInType;    // 납입유형 (코드)

    public BankAccFundSearch(String memberId, String orgCd, String accountNum, String seqno, String standardFundCode, String paidInType) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.seqno = seqno;
        this.standardFundCode = standardFundCode;
        this.paidInType = paidInType;
    }

    public BankAccFundSearch(BankAccFundEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
        this.standardFundCode = entity.getStandardFundCode();
        this.paidInType = entity.getPaidInType();
    }

    public BankAccFundSearch(BankAccFundForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
        this.standardFundCode = form.getStandardFundCode();
        this.paidInType = form.getPaidInType();
    }
}