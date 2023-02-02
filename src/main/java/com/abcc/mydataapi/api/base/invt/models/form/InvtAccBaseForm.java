package com.abcc.mydataapi.api.base.invt.models.form;

import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccBaseForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String currencyCode;    // 통화코드
    private BigDecimal withholdingsAmt;    // 예수금
    private BigDecimal creditLoanAmt;    // 신용 융자
    private BigDecimal mortgageAmt;    // 대출금
    private BigDecimal availBalance;    // 출금가능금액

    public InvtAccBaseEntity getEntity(){
        InvtAccBaseEntity entity = new InvtAccBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setCurrencyCode(currencyCode);
        entity.setWithholdingsAmt(withholdingsAmt);
        entity.setCreditLoanAmt(creditLoanAmt);
        entity.setMortgageAmt(mortgageAmt);
        entity.setAvailBalance(availBalance);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
