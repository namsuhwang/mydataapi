package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu018ResDto extends ResBaseDto {

    private String insuNum;    // 증권번호
    private Boolean isRenewable;    // 갱신여부 (여부)
    private String issueDate;    // 계약체결일
    private String expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)

    @JsonProperty("prize_cnt")
    private Integer listCnt;

    @JsonProperty("prize_list")
    private List<Insu018ResDetailDto> list;

    public InsuMiBaseForm getForm(FormBase formBase){
        InsuMiBaseForm form = new InsuMiBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setIsRenewable(isRenewable ? "Y" : "N");
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setFaceAmt(faceAmt);
        form.setCurrencyCode(currencyCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
