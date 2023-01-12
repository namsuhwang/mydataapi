package com.kpcnc.mydataapi.api.load.bank.models;

import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccEachProdEntity;
import com.kpcnc.mydataapi.api.load.bank.models.form.BankAccEachProdForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccEachProdSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호

    public BankAccEachProdSearch(String memberId, String orgCd, String accountNum, String prodName, String prodNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.prodName = prodName;
        this.prodNum = prodNum;
    }

    public BankAccEachProdSearch(BankAccEachProdEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.prodName = entity.getProdName();
        this.prodNum = entity.getProdNum();
    }

    public BankAccEachProdSearch(BankAccEachProdForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.prodName = form.getProdName();
        this.prodNum = form.getProdNum();
    }
}
