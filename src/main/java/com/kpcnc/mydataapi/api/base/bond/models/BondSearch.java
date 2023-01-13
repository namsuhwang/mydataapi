package com.kpcnc.mydataapi.api.base.bond.models;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BondSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호

    public BondSearch(String memberId, String orgCd, String bondNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.bondNum = bondNum;
    }

    public BondSearch(BondEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.bondNum = entity.getBondNum();
    }

    public BondSearch(BondForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.bondNum = form.getBondNum();
    }
}
