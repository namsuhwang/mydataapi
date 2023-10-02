package com.albee.mydataapi.api.base.invt.models;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccBaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
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
