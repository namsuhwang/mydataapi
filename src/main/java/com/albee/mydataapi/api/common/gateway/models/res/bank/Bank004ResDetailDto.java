package com.albee.mydataapi.api.common.gateway.models.res.bank;

import com.albee.mydataapi.api.base.bank.models.form.BankAccDepositHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class Bank004ResDetailDto {
    private String transDtime;
    private String transNo;
    private String transType;
    private String transClass;
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;
    private BigDecimal balanceAmt;
    private Integer paidInCnt;
    private String transMemo;

    public BankAccDepositHistForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccDepositHistForm form = new BankAccDepositHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransType(transType);
        form.setTransClass(transClass);
        form.setCurrencyCode(currencyCode);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setPaidInCnt(paidInCnt);
        form.setTransMemo(transMemo);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
