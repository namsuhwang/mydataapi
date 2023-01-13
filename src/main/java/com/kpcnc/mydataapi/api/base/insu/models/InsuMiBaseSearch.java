package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuMiBaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호

    public InsuMiBaseSearch(String memberId, String orgCd, String insuNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
    }

    public InsuMiBaseSearch(InsuMiBaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
    }

    public InsuMiBaseSearch(InsuMiBaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
    }
}
