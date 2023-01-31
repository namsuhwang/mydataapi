package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiPayEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiPayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuMiPaySearch extends SearchDto {
    private String insuNum;    // 증권번호

    public InsuMiPaySearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuMiPaySearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuMiPaySearch(InsuMiPayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public InsuMiPaySearch(InsuMiPayForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
