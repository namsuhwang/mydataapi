package com.kpcnc.mydataapi.api.base.invt.models.form;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtPensionAccAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String issueDate;    // 연금가입일
    private BigDecimal paidInAmt;    // 납부총액
    private BigDecimal withdrawalAmt;    // 기출금액
    private String lastPaidInDate;    // 최종납입일
    private BigDecimal rcvAmt;    // 연금기수령액
    private String pensionRcvStartDate;    // 연금개시(예정)일
    private BigDecimal annualPayAmount;    // 금년납입금
    private String currencyCode;    // 통화코드

    public InvtPensionAccAddEntity getEntity(){
        InvtPensionAccAddEntity entity = new InvtPensionAccAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setIssueDate(issueDate);
        entity.setPaidInAmt(paidInAmt);
        entity.setWithdrawalAmt(withdrawalAmt);
        entity.setLastPaidInDate(lastPaidInDate);
        entity.setRcvAmt(rcvAmt);
        entity.setPensionRcvStartDate(pensionRcvStartDate);
        entity.setAnnualPayAmount(annualPayAmount);
        entity.setCurrencyCode(currencyCode);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
