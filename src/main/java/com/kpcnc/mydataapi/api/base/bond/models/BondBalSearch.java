package com.kpcnc.mydataapi.api.base.bond.models;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class BondBalSearch extends SearchDto {
    private String bondNum;    // 채권번호

    public BondBalSearch(String memberId, String orgCd, String bondNum) {
        super(memberId, orgCd);
        this.bondNum = bondNum;
    }

    public BondBalSearch(BondBalEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.bondNum = entity.getBondNum();
    }

    public BondBalSearch(BondBalForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.bondNum = form.getBondNum();
    }
}
