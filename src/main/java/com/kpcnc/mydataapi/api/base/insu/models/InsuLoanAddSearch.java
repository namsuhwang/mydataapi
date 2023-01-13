package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuLoanAddSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호

    public InsuLoanAddSearch(String memberId, String orgCd, String accountNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
    }

    public InsuLoanAddSearch(InsuLoanAddEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
    }

    public InsuLoanAddSearch(InsuLoanAddForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
    }
}
