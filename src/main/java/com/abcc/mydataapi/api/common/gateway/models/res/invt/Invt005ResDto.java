package com.abcc.mydataapi.api.common.gateway.models.res.invt;

import com.abcc.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Invt005ResDto extends ResBaseDto {

    private String issueDate;    // 연금가입일
    private BigDecimal paidInAmt;    // 납부총액
    private BigDecimal withdrawalAmt;    // 기출금액
    private String lastPaidInDate;    // 최종납입일
    private BigDecimal rcvAmt;    // 연금기수령액
    private String pensionRcvStartDate;    // 연금개시(예정)일
    private BigDecimal annualPayAmount;    // 금년납입금
    private String currencyCode;    // 통화코드

    public InvtPensionAccAddForm getForm(FormBase formBase, String accountNum){
        InvtPensionAccAddForm form = new InvtPensionAccAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setIssueDate(issueDate);
        form.setPaidInAmt(paidInAmt);
        form.setWithdrawalAmt(withdrawalAmt);
        form.setLastPaidInDate(lastPaidInDate);
        form.setRcvAmt(rcvAmt);
        form.setPensionRcvStartDate(pensionRcvStartDate);
        form.setAnnualPayAmount(annualPayAmount);
        form.setCurrencyCode(currencyCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
