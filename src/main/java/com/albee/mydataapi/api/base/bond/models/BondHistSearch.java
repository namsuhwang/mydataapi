package com.albee.mydataapi.api.base.bond.models;

import com.albee.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.albee.mydataapi.api.base.bond.models.form.BondHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BondHistSearch extends SearchDto {
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자

    public BondHistSearch(String memberId, String orgCd, String bondNum) {
        super(memberId, orgCd);
        this.bondNum = bondNum;
    }

    public BondHistSearch(String memberId, String orgCd, String bondNum, String transDtime) {
        super(memberId, orgCd);
        this.bondNum = bondNum;
        this.transDtime = transDtime;
    }

    public BondHistSearch(BondHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.bondNum = entity.getBondNum();
        this.transDtime = entity.getTransDtime();
    }

    public BondHistSearch(BondHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.bondNum = form.getBondNum();
        this.transDtime = form.getTransDtime();
    }
}
