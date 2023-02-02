package com.albee.mydataapi.api.common.gateway.models.res.bank;

import com.albee.mydataapi.api.base.bank.models.form.BankAccFundHistForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Bank007ResDetailDto {
    private String transDtime;
    private String transNo;
    private String transType;
    private String currencyCode;    // 통화코드
    private BigDecimal baseAmt;    // 기준가
    private BigDecimal transFundNum;    // 거래좌수
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔고평가금액

    public BankAccFundHistForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccFundHistForm form = new BankAccFundHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransType(transType);
        form.setCurrencyCode(currencyCode);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setBaseAmt(baseAmt);
        form.setTransFundNum(transFundNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
