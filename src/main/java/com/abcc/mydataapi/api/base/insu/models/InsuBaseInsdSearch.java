package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseInsdForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuBaseInsdSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험자 번호

    public InsuBaseInsdSearch(String memberId, String orgCd, String insuNum, String insuredNo) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.insuredNo = insuredNo;
    }

    public InsuBaseInsdSearch(InsuBaseInsdEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.insuredNo = entity.getInsuredNo();
    }

    public InsuBaseInsdSearch(InsuBaseInsdForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.insuredNo = form.getInsuredNo();
    }
}
