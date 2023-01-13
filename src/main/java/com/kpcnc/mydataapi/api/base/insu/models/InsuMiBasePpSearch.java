package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuMiBasePpSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String isPerson;    // 인/물 구분코드
    private String prizeNum;    // 피보험인/물 번호

    public InsuMiBasePpSearch(String memberId, String orgCd, String insuNum, String isPerson, String prizeNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.isPerson = isPerson;
        this.prizeNum = prizeNum;
    }

    public InsuMiBasePpSearch(InsuMiBasePpEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.isPerson = entity.getIsPerson();
        this.prizeNum = entity.getPrizeNum();
    }

    public InsuMiBasePpSearch(InsuMiBasePpForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.isPerson = form.getIsPerson();
        this.prizeNum = form.getPrizeNum();
    }
}
