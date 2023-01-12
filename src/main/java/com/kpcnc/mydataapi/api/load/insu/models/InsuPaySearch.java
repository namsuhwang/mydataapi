package com.kpcnc.mydataapi.api.load.insu.models;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuPaySearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호

    public InsuPaySearch(String memberId, String orgCd, String insuNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
    }

    public InsuPaySearch(InsuPayEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
    }

    public InsuPaySearch(InsuPayForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
    }
}
