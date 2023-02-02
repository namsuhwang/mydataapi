package com.abcc.mydataapi.api.base.invt.models;

import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAccProdBaseDateSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String baseDate;    // 기준일자

    public InvtAccProdBaseDateSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAccProdBaseDateSearch(String memberId, String orgCd, String accountNum, String baseDate) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.baseDate = baseDate;
    }

    public InvtAccProdBaseDateSearch(InvtAccProdBaseDateEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.baseDate = entity.getBaseDate();
    }

    public InvtAccProdBaseDateSearch(InvtAccProdBaseDateForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.baseDate = form.getBaseDate();
    }
}
