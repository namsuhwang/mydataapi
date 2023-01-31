package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuMiHistSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String transDate;    // 납입일자
    private Integer transAppliedMonth;    // 납입연월
    private Integer paidInCnt;    // 납입회차

    public InsuMiHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuMiHistSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuMiHistSearch(String memberId, String orgCd, String insuNum, String transDate, Integer transAppliedMonth, Integer paidInCnt) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.transDate = transDate;
        this.transAppliedMonth = transAppliedMonth;
        this.paidInCnt = paidInCnt;
    }

    public InsuMiHistSearch(InsuMiHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.transDate = entity.getTransDate();
        this.transAppliedMonth = entity.getTransAppliedMonth();
        this.paidInCnt = entity.getPaidInCnt();
    }

    public InsuMiHistSearch(InsuMiHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.transDate = form.getTransDate();
        this.transAppliedMonth = form.getTransAppliedMonth();
        this.paidInCnt = form.getPaidInCnt();
    }
}
