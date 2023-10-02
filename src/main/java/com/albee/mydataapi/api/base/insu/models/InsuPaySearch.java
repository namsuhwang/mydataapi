package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
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
