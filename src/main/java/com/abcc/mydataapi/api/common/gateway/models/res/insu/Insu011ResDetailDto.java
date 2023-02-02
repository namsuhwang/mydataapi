package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanHistForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
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
public class Insu011ResDetailDto {

    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String currencyCode;    // 통화코드(대 출원금상환액 및 이자납입액)
    private BigDecimal loanPaidAmt;    // 대출원금상환 액
    private BigDecimal intPaidAmt;    // 이자납입액

    @JsonProperty("int_cnt")
    private Integer listCnt;

    @JsonProperty("int_list")
    private List<Insu011ResDetailIntDto> list;

    public InsuLoanHistForm getForm(FormBase formBase, String accountNum){
        InsuLoanHistForm form = new InsuLoanHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setTransNo(transNo);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setCurrencyCode(currencyCode);
        form.setLoanPaidAmt(loanPaidAmt);
        form.setIntPaidAmt(intPaidAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
