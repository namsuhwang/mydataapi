package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuGurtForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)
    private String status;    // 담보상태 (코드)
    private String coverageCode;    // 담보 (코드)
    private Integer type;    // 담보특성 (코드)
    private String coverageNum;    // 회사담보일렬 번호
    private String coverageName;    // 회사담보명
    private Long coverageAmt;    // 담보금액
    private String startDate;    // 담보기간 시작일자
    private String endDate;    // 담보기간 종료일자
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuGurtEntity getEntity(){
        InsuGurtEntity entity = new InsuGurtEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setSubject(subject);
        entity.setRelation(relation);
        entity.setStatus(status);
        entity.setCoverageCode(coverageCode);
        entity.setType(type);
        entity.setCoverageNum(coverageNum);
        entity.setCoverageName(coverageName);
        entity.setCoverageAmt(coverageAmt);
        entity.setStartDate(startDate);
        entity.setEndDate(endDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}