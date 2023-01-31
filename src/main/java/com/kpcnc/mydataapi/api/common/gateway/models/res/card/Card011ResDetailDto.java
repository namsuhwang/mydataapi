package com.kpcnc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.card.models.form.CardAprOsHistForm;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
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
public class Card011ResDetailDto {

    private String loanDtime;    // 이용일시
    private Long loanAmt;    // 이용금액(취급액)
    private Long balanceAmt;    // 단기대출 잔액
    private String payDueDate;    // 결제예정일
    private Float intRate;    // 이자율
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호

    public CardLoanStForm getForm(FormBase formBase){
        CardLoanStForm form = new CardLoanStForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLoanDtime(loanDtime);
        form.setLoanAmt(loanAmt);
        form.setBalanceAmt(balanceAmt);
        form.setPayDueDate(payDueDate);
        form.setIntRate(intRate);
        form.setRepayOrgCode(repayOrgCode);
        form.setRepayAccountNum(repayAccountNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
