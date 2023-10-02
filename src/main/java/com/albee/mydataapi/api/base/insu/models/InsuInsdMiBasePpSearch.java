package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InsuInsdMiBasePpSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String prizeNum;    // 피보험인/물 번호

    public InsuInsdMiBasePpSearch(String memberId, String orgCd, String insuNum, String prizeNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.prizeNum = prizeNum;
    }

    public InsuInsdMiBasePpSearch(InsuInsdMiBasePpEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.prizeNum = entity.getPrizeNum();
    }

    public InsuInsdMiBasePpSearch(InsuInsdMiBasePpForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.prizeNum = form.getPrizeNum();
    }
}
