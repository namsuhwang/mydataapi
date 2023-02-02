package com.abcc.mydataapi.api.base.invt.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InvtPensionAccAddSearch extends SearchDto {
    private String accountNum;    // 계좌번호

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
