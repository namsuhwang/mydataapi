package com.kpcnc.mydataapi.api.base.irp.models;

import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
