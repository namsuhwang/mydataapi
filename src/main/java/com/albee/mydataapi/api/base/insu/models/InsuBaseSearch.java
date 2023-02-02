package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InsuBaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호

    public InsuBaseSearch(String memberId, String orgCd, String insuNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
    }

    public InsuBaseSearch(InsuBaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
    }

    public InsuBaseSearch(InsuBaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
    }
}
