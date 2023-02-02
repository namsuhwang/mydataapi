package com.abcc.mydataapi.api.base.invt.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAutoTransForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAutoTransSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public InvtAutoTransSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtAutoTransSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAutoTransSearch(InvtAutoTransEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public InvtAutoTransSearch(InvtAutoTransForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
