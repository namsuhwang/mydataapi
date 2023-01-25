package com.kpcnc.mydataapi.api.base.bank.models;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccProdEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccProdForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BankAccProdSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public BankAccProdSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAccProdSearch(BankAccProdEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public BankAccProdSearch(BankAccProdForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
