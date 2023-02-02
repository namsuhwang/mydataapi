package com.albee.mydataapi.api.base.irp.models;

import com.albee.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class IrpAccBaseSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public IrpAccBaseSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public IrpAccBaseSearch(IrpAccBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public IrpAccBaseSearch(IrpAccBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
