package com.abcc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanAddForm;
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
public class Insu010ResDto extends ResBaseDto {

    private String currencyCode;    // 통화코드(대 출원금 및 대출원금잔액)
    private BigDecimal balanceAmt;    // 대출잔액
    private BigDecimal loanPrincipal;    // 대출원금
    private String nextRepayDate;    // 다음 이자 상환일

    public InsuLoanAddForm getForm(FormBase formBase, String accountNum){
        InsuLoanAddForm form = new InsuLoanAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setLoanPrincipal(loanPrincipal);
        form.setNextRepayDate(nextRepayDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
