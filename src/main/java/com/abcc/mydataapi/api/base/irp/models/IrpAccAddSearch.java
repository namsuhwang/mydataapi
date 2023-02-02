package com.abcc.mydataapi.api.base.irp.models;

import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class IrpAccAddSearch extends SearchDto {
    private String irpName;    // 개별운용상품명

    public IrpAccAddSearch(String memberId, String orgCd, String irpName) {
        super(memberId, orgCd);
        this.irpName = irpName;
    }

    public IrpAccAddSearch(IrpAccAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.irpName = entity.getIrpName();
    }

    public IrpAccAddSearch(IrpAccAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.irpName = form.getIrpName();
    }
}
