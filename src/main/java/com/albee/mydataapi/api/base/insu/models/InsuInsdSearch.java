package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
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
