package com.abcc.mydataapi.api.base.bank.models;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import com.abcc.mydataapi.api.base.bank.models.form.BankAccProdHistForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BankAccProdHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래구분(코드)

    public BankAccProdHistSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAccProdHistSearch(String memberId, String orgCd, String accountNum, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public BankAccProdHistSearch(String memberId, String orgCd, String accountNum, String transDtime, String transNo, String transType) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.transDtime = transDtime;
        this.transNo = transNo;
        this.transType = transType;
    }

    public BankAccProdHistSearch(BankAccProdHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
        this.transType = entity.getTransType();
    }

    public BankAccProdHistSearch(BankAccProdHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
        this.transType = form.getTransType();
    }
}
