package com.kpcnc.mydataapi.api.base.invt.models;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAccHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자

    public InvtAccHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtAccHistSearch(String memberId, String orgCd, String accountNum, String transDtime) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.transDtime = transDtime;
    }

    public InvtAccHistSearch(InvtAccHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.accountNum = entity.getAccountNum();
        this.transDtime = entity.getTransDtime();
    }

    public InvtAccHistSearch(InvtAccHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.accountNum = form.getAccountNum();
        this.transDtime = form.getTransDtime();
    }
}
