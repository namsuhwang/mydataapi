package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdSearch extends SearchDto {
    private String insuNum;    // 증권번호

    public InsuInsdSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuInsdSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuInsdSearch(InsuInsdEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public InsuInsdSearch(InsuInsdForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
