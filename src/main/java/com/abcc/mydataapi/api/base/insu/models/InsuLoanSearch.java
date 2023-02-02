package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuLoanSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public InsuLoanSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuLoanSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InsuLoanSearch(InsuLoanEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public InsuLoanSearch(InsuLoanForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
