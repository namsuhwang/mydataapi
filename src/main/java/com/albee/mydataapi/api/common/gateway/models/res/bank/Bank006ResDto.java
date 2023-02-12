package com.albee.mydataapi.api.common.gateway.models.res.bank;

import com.albee.mydataapi.api.base.bank.models.form.BankAccFundAddForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Bank006ResDto extends ResBaseDto {
    private String currencyCode;   // 통화코드

    private BigDecimal balanceAmt;   // 잔액

    private BigDecimal evalAmt;   // 평가금액

    private BigDecimal invPrincipal;   // 투자원금

    private BigDecimal fundNum;   // 보유좌수

    public BankAccFundAddForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccFundAddForm form = new BankAccFundAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setCurrencyCode(currencyCode);
        form.setBalanceAmt(balanceAmt);
        form.setEvalAmt(evalAmt);
        form.setInvPrincipal(invPrincipal);
        form.setFundNum(fundNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
