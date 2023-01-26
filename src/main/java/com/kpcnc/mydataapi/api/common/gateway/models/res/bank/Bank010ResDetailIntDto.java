package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistIntForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
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
public class Bank010ResDetailIntDto {
    private String transDtime;
    private String transNo;
    private String intStartDate;    // 이자적용시작일
    private String intEndDate;    // 이자적용종료일
    private Float intRate;    // 적용이율
    private BigDecimal appliedIntAmt;    // 이자금액
    private String intType;    // 이자종류(코드)

    public BankAccLoanHistIntForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccLoanHistIntForm form = new BankAccLoanHistIntForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setIntStartDate(intStartDate);
        form.setIntEndDate(intEndDate);
        form.setIntRate(intRate);
        form.setAppliedIntAmt(appliedIntAmt);
        form.setIntType(intType);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
