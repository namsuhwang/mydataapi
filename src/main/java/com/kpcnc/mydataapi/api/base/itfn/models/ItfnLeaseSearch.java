package com.kpcnc.mydataapi.api.base.itfn.models;

import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnLeaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호

    public ItfnLeaseSearch(String memberId, String orgCd, String accountNum, String seqno) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public ItfnLeaseSearch(ItfnLeaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.seqno = entity.getSeqno();
    }

    public ItfnLeaseSearch(ItfnLeaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.seqno = form.getSeqno();
    }
}