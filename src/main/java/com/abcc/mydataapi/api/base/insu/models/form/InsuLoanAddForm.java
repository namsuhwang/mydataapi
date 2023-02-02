package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드(대 출원금 및 대출원금잔액)
    private BigDecimal balanceAmt;    // 대출잔액
    private BigDecimal loanPrincipal;    // 대출원금
    private String nextRepayDate;    // 다음 이자 상환일

    public InsuLoanAddEntity getEntity(){
        InsuLoanAddEntity entity = new InsuLoanAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setLoanPrincipal(loanPrincipal);
        entity.setNextRepayDate(nextRepayDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
