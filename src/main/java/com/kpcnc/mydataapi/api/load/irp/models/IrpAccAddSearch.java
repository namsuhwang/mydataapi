package com.kpcnc.mydataapi.api.load.irp.models;

import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccAddEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccAddForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class IrpAccAddSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String irpName;    // 개별운용상품명

    public IrpAccAddSearch(String memberId, String orgCd, String irpName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.irpName = irpName;
    }

    public IrpAccAddSearch(IrpAccAddEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.irpName = entity.getIrpName();
    }

    public IrpAccAddSearch(IrpAccAddForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.irpName = form.getIrpName();
    }
}
