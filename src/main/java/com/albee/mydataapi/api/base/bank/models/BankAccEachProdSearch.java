package com.albee.mydataapi.api.base.bank.models;

import com.albee.mydataapi.api.base.bank.models.entity.BankAccEachProdEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankAccEachProdForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BankAccEachProdSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호

    public BankAccEachProdSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.prodName = prodName;
    }

    public BankAccEachProdSearch(String memberId, String orgCd, String accountNum, String prodName) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.prodName = prodName;
    }

    public BankAccEachProdSearch(String memberId, String orgCd, String accountNum, String prodName, String prodNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.prodName = prodName;
        this.prodNum = prodNum;
    }

    public BankAccEachProdSearch(BankAccEachProdEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.prodName = entity.getProdName();
        this.prodNum = entity.getProdNum();
    }

    public BankAccEachProdSearch(BankAccEachProdForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.prodName = form.getProdName();
        this.prodNum = form.getProdNum();
    }
}
