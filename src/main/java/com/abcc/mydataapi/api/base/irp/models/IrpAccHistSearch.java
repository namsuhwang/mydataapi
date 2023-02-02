package com.abcc.mydataapi.api.base.irp.models;

import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccHistForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class IrpAccHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자

    public IrpAccHistSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public IrpAccHistSearch(String memberId, String orgCd, String accountNum, String transDtime) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.transDtime = transDtime;
    }

    public IrpAccHistSearch(IrpAccHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.transDtime = entity.getTransDtime();
    }

    public IrpAccHistSearch(IrpAccHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.transDtime = form.getTransDtime();
    }
}
