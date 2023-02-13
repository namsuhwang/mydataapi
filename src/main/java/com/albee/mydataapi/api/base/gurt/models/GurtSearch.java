package com.albee.mydataapi.api.base.gurt.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class GurtSearch extends SearchDto {
    private String insuNum;    // 증권번호


    public GurtSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public GurtSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public GurtSearch(GurtEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public GurtSearch(GurtForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
