package com.albee.mydataapi.api.base.irp.models;

import com.albee.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class IrpAccSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public IrpAccSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public IrpAccSearch(IrpAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public IrpAccSearch(IrpAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
