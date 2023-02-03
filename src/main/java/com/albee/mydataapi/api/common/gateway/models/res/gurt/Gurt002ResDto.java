package com.albee.mydataapi.api.common.gateway.models.res.gurt;

import com.albee.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Gurt002ResDto extends ResBaseDto {

    private String issueDate;    // 계약체결일
    private String expDate;    // 종료일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String payDue;    // 납입기간구분(코드)
    private BigDecimal payAmt;    // 총 납입 보험료

    @JsonProperty("insured_cnt")
    private Integer listCnt;

    @JsonProperty("insured_list")
    private List<Gurt002ResDetailDto> list;

    public GurtBaseForm getForm(FormBase formBase, String insuNum){
        GurtBaseForm form = new GurtBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setFaceAmt(faceAmt);
        form.setPayDue(payDue);
        form.setPayAmt(payAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
