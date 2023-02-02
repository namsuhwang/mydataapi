package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanStForm extends FormBase {
    private String loanDtime;    // 이용일시
    private Long loanAmt;    // 이용금액(취급액)
    private Long balanceAmt;    // 단기대출 잔액
    private String payDueDate;    // 결제예정일
    private Float intRate;    // 이자율
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호

    public CardLoanStForm(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardLoanStEntity getEntity(){
        CardLoanStEntity entity = new CardLoanStEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLoanDtime(loanDtime);
        entity.setLoanAmt(loanAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setPayDueDate(payDueDate);
        entity.setIntRate(intRate);
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
