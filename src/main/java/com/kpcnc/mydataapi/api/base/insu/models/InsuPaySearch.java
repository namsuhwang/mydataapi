package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuPaySearch extends SearchDto {
    private String insuNum;    // 증권번호

    public InsuPaySearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuPaySearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuPaySearch(InsuPayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public InsuPaySearch(InsuPayForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
