package com.albee.mydataapi.api.base.bank.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.bank.models.entity.BankCustEntity;
import com.albee.mydataapi.api.base.bank.models.form.BankCustForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BankCustSearch extends SearchDto {
    private String regDate;    // 고객생성일

    public BankCustSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public BankCustSearch(String memberId, String orgCd, String regDate) {
        super(memberId, orgCd);
        this.regDate = regDate;
    }

    public BankCustSearch(BankCustEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.regDate = entity.getRegDate();
    }

    public BankCustSearch(BankCustForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.regDate = form.getRegDate();
    }
}
