package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdBaseForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Insu014ResDto extends ResBaseDto {

    private Boolean isRenewable;    // 갱신여부 (여부)
    private String issueDate;    // 계약체결일
    private String expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private Boolean isVariable;    // 변액보험 여부
    private Boolean isUniversal;    // 유니버셜 여부
    private String issuerName;    // 계약자명
    private Boolean isPrimary;    // 주피보험자 여부

    public InsuInsdBaseForm getForm(FormBase formBase, String insuNum){
        InsuInsdBaseForm form = new InsuInsdBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setIsRenewable(isRenewable ? "Y" : "N");
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setFaceAmt(faceAmt);
        form.setCurrencyCode(currencyCode);
        form.setIsVariable(isVariable ? "Y" : "N");
        form.setIsUniversal(isUniversal ? "Y" : "N");
        form.setIssuerName(issuerName);
        form.setIsPrimary(isPrimary ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
