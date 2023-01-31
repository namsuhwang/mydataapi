package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuSearch extends SearchDto {
    private String insuNum;    // 증권번호

    public InsuSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuSearch(InsuEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public InsuSearch(InsuForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
