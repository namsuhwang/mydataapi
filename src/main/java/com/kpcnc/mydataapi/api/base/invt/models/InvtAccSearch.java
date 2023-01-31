package com.kpcnc.mydataapi.api.base.invt.models;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAccSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public InvtAccSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtAccSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAccSearch(InvtAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public InvtAccSearch(InvtAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
