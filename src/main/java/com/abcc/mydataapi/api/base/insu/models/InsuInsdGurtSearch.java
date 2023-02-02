package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdGurtSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private Integer gurtSeq;    // 보장일련번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)

    public InsuInsdGurtSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuInsdGurtSearch(String memberId, String orgCd, String insuNum, Integer gurtSeq, String subject, String relation) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.gurtSeq = gurtSeq;
        this.subject = subject;
        this.relation = relation;
    }

    public InsuInsdGurtSearch(InsuInsdGurtEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.gurtSeq = entity.getGurtSeq();
        this.subject = entity.getSubject();
        this.relation = entity.getRelation();
    }

    public InsuInsdGurtSearch(InsuInsdGurtForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.gurtSeq = form.getGurtSeq();
        this.subject = form.getSubject();
        this.relation = form.getRelation();
    }
}
