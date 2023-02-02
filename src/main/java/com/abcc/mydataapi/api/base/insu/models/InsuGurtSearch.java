package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuGurtForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuGurtSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)

    public InsuGurtSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuGurtSearch(String memberId, String orgCd, String insuNum, String subject, String relation) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.subject = subject;
        this.relation = relation;
    }

    public InsuGurtSearch(InsuGurtEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.subject = entity.getSubject();
        this.relation = entity.getRelation();
    }

    public InsuGurtSearch(InsuGurtForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.subject = form.getSubject();
        this.relation = form.getRelation();
    }
}
