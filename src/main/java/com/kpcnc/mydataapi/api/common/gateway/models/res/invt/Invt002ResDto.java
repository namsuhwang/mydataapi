package com.kpcnc.mydataapi.api.common.gateway.models.res.invt;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Invt002ResDto extends ResBaseDto {

    private String currencyCode;    // 통화코드
    private BigDecimal withholdingsAmt;    // 예수금
    private BigDecimal creditLoanAmt;    // 신용 융자
    private BigDecimal mortgageAmt;    // 대출금
    private BigDecimal availBalance;    // 출금가능금액

    public InvtAccBaseForm getForm(FormBase formBase, String accountNum){
        InvtAccBaseForm form = new InvtAccBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setCurrencyCode(currencyCode);
        form.setWithholdingsAmt(withholdingsAmt);
        form.setCreditLoanAmt(creditLoanAmt);
        form.setMortgageAmt(mortgageAmt);
        form.setAvailBalance(availBalance);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
