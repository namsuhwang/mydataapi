package com.kpcnc.mydataapi.api.base.gurt.models;

import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
