package com.kpcnc.mydataapi.api.load.itfn.models;

import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnAccEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnAccForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ItfnAccSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호

    public ItfnAccSearch(String memberId, String orgCd, String accountNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
    }

    public ItfnAccSearch(ItfnAccEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
    }

    public ItfnAccSearch(ItfnAccForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
    }
}
