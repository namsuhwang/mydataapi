package com.albee.mydataapi.api.base.gurt.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class GurtBaseSearch extends SearchDto {
    private String insuNum;    // 증권번호

    public GurtBaseSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public GurtBaseSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public GurtBaseSearch(GurtBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
    }

    public GurtBaseSearch(GurtBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
    }
}
