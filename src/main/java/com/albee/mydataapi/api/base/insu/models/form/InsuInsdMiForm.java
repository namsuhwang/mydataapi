package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdMiForm extends FormBase {
    private String insuNum;    // 증권번호
    private Integer gurtSeq;    // 보장일련번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)
    private String status;    // 담보상태 (코드)
    private String coverageCode;    // 담보 (코드)
    private String type;    // 담보특성 (코드)
    private String coverageNum;    // 회사담보일렬 번호
    private String coverageName;    // 회사담보명
    private Long coverageAmt;    // 담보금액
    private String startDate;    // 담보기간 시작일자
    private String endDate;    // 담보기간 종료일자

    public InsuInsdMiEntity getEntity(){
        InsuInsdMiEntity entity = new InsuInsdMiEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setGurtSeq(gurtSeq);
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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
