package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanLgForm extends FormBase {
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

    public CardLoanLgEntity getEntity(){
        CardLoanLgEntity entity = new CardLoanLgEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLoanNum(loanNum);
        entity.setLoanDtime(loanDtime);
        entity.setLoanCnt(loanCnt);
        entity.setLoanType(loanType);
        entity.setLoanName(loanName);
        entity.setLoanAmt(loanAmt);
        entity.setIntRate(intRate);
        entity.setExpDate(expDate);
        entity.setBalanceAmt(balanceAmt);
        entity.setRepayMethod(repayMethod);
        entity.setIntAmt(intAmt);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
