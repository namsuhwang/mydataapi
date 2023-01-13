package com.kpcnc.mydataapi.api.load.invt.models;

import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAutoTransEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAutoTransForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAutoTransSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호

    public InvtAutoTransSearch(String memberId, String orgCd, String accountNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
    }

    public InvtAutoTransSearch(InvtAutoTransEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
    }

    public InvtAutoTransSearch(InvtAutoTransForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
    }
}
