package com.abcc.mydataapi.api.base.irp.models;

import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
