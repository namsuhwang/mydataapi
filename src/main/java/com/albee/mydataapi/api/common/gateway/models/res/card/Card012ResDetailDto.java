package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.albee.mydataapi.common.models.form.FormBase;
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
public class Card012ResDetailDto {

    private String loanNum;    // 대출번호
    private String loanDtime;    // 대출일시 또는 대출일자
    private Integer loanCnt;    // 일자의 대출회차
    private String loanType;    // 대출종류
    private String loanName;    // 상품명
    private BigDecimal loanAmt;    // 이용금액
    private Float intRate;    // 이자율
    private String expDate;    // 만기일
    private BigDecimal balanceAmt;    // 장기대출 잔액
    private String repayMethod;    // 상환방법 (코드)
    private BigDecimal intAmt;    // 상환액 중 이자
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호

    public CardLoanLgForm getForm(FormBase formBase){
        CardLoanLgForm form = new CardLoanLgForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLoanNum(loanNum);
        form.setLoanDtime(loanDtime);
        form.setLoanCnt(loanCnt);
        form.setLoanType(loanType);
        form.setLoanName(loanName);
        form.setLoanAmt(loanAmt);
        form.setIntRate(intRate);
        form.setExpDate(expDate);
        form.setBalanceAmt(balanceAmt);
        form.setRepayMethod(repayMethod);
        form.setIntAmt(intAmt);
        form.setRepayOrgCode(repayOrgCode);
        form.setRepayAccountNum(repayAccountNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
