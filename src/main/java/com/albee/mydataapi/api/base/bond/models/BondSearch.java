package com.albee.mydataapi.api.base.bond.models;

import com.albee.mydataapi.api.base.bond.models.entity.BondEntity;
import com.albee.mydataapi.api.base.bond.models.form.BondForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class BondSearch extends SearchDto {
    private String bondNum;    // 채권번호

    public BondSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public BondSearch(String memberId, String orgCd, String bondNum) {
        super(memberId, orgCd);
        this.bondNum = bondNum;
    }

    public BondSearch(BondEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.bondNum = entity.getBondNum();
    }

    public BondSearch(BondForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.bondNum = form.getBondNum();
    }
}
