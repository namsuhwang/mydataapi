package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Insu002ResDto extends ResBaseDto {

    private String insuNum;    // 증권번호
    private Boolean isRenewable;    // 갱신여부 (여부)
    private String issueDate;    // 계약체결일
    private String expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private Boolean isVariable;    // 변액보험 여부
    private Boolean isUniversal;    // 유니버셜 여부
    private String pensionRcvStartDate;    // 연금개시일
    private String pensionRcvCycle;    // 연금수령주기
    private Boolean isLoanable;    // 대출실행 가능 상품 여부

    @JsonProperty("insured_cnt")
    private Integer listCnt;

    @JsonProperty("insured_list")
    private List<Insu002ResDetailDto> list;


    public InsuBaseForm getForm(FormBase formBase){
        InsuBaseForm form = new InsuBaseForm();
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
        form.setPensionRcvStartDate(pensionRcvStartDate);
        form.setPensionRcvCycle(pensionRcvCycle);
        form.setIsLoanable(isLoanable ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
