package com.kpcnc.mydataapi.api.base.invt.models;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtPensionAccAddSearch extends SearchDto {
    private String accountNum;    // 계좌번호

    public InvtPensionAccAddSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtPensionAccAddSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtPensionAccAddSearch(InvtPensionAccAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
    }

    public InvtPensionAccAddSearch(InvtPensionAccAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
    }
}
