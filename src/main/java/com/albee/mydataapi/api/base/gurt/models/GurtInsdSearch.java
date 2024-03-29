package com.albee.mydataapi.api.base.gurt.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtInsdForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class GurtInsdSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String insuredName;    // 피보험자명


    public GurtInsdSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public GurtInsdSearch(String memberId, String orgCd, String insuNum, String insuredName) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.insuredName = insuredName;
    }

    public GurtInsdSearch(GurtInsdEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.insuredName = entity.getInsuredName();
    }

    public GurtInsdSearch(GurtInsdForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.insuredName = form.getInsuredName();
    }
}
