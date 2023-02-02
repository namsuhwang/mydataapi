package com.albee.mydataapi.api.base.invt.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccHistForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InvtAccHistSearch extends SearchDto {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래일련번호

    public InvtAccHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InvtAccHistSearch(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public InvtAccHistSearch(String memberId, String orgCd, String accountNum, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.transDtime = transDtime;
        this.transNo = transNo;
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
