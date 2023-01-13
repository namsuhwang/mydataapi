package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String transDate;    // 납입일자
    private Integer transAppliedMonth;    // 납입연월
    private Integer paidInCnt;    // 납입회차

    public InsuHistSearch(String memberId, String orgCd, String insuNum, String transDate, Integer transAppliedMonth, Integer paidInCnt) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.transDate = transDate;
        this.transAppliedMonth = transAppliedMonth;
        this.paidInCnt = paidInCnt;
    }

    public InsuHistSearch(InsuHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.transDate = entity.getTransDate();
        this.transAppliedMonth = entity.getTransAppliedMonth();
        this.paidInCnt = entity.getPaidInCnt();
    }

    public InsuHistSearch(InsuHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.transDate = form.getTransDate();
        this.transAppliedMonth = form.getTransAppliedMonth();
        this.paidInCnt = form.getPaidInCnt();
    }
}
