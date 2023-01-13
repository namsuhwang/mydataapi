package com.kpcnc.mydataapi.api.load.invt.models;

import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InvtAccHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자

    public InvtAccHistSearch(String memberId, String orgCd, String accountNum, String transDtime) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.transDtime = transDtime;
    }

    public InvtAccHistSearch(InvtAccHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.transDtime = entity.getTransDtime();
    }

    public InvtAccHistSearch(InvtAccHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.transDtime = form.getTransDtime();
    }
}
