package com.abcc.mydataapi.api.base.gurt.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
