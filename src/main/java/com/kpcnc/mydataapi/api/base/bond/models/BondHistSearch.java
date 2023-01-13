package com.kpcnc.mydataapi.api.base.bond.models;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BondHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자

    public BondHistSearch(String memberId, String orgCd, String bondNum, String transDtime) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.bondNum = bondNum;
        this.transDtime = transDtime;
    }

    public BondHistSearch(BondHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.bondNum = entity.getBondNum();
        this.transDtime = entity.getTransDtime();
    }

    public BondHistSearch(BondHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.bondNum = form.getBondNum();
        this.transDtime = form.getTransDtime();
    }
}
