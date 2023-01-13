package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdMiSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private Integer gurtSeq;    // 보장일련번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)

    public InsuInsdMiSearch(String memberId, String orgCd, String insuNum, Integer gurtSeq, String subject, String relation) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.gurtSeq = gurtSeq;
        this.subject = subject;
        this.relation = relation;
    }

    public InsuInsdMiSearch(InsuInsdMiEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.gurtSeq = entity.getGurtSeq();
        this.subject = entity.getSubject();
        this.relation = entity.getRelation();
    }

    public InsuInsdMiSearch(InsuInsdMiForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.gurtSeq = form.getGurtSeq();
        this.subject = form.getSubject();
        this.relation = form.getRelation();
    }
}
