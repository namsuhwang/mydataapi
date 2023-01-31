package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu024ResDetailDto {

    private String insuNum;    // 증권번호
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

    public InsuMiForm getForm(FormBase formBase, String insuNum){
        InsuMiForm form = new InsuMiForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setSubject(subject);
        form.setRelation(relation);
        form.setStatus(status);
        form.setCoverageCode(coverageCode);
        form.setType(type);
        form.setCoverageNum(coverageNum);
        form.setCoverageName(coverageName);
        form.setCoverageAmt(coverageAmt);
        form.setStartDate(startDate);
        form.setEndDate(endDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
