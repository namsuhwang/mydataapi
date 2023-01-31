package com.kpcnc.mydataapi.api.base.invt.models;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAccBaseSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public InvtAccBaseSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtAccBaseSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAccBaseSearch(InvtAccBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public InvtAccBaseSearch(InvtAccBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
