package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanStForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanDtime;    // 이용일시
    private Long loanAmt;    // 이용금액(취급액)
    private Long balanceAmt;    // 단기대출 잔액
    private String payDueDate;    // 결제예정일
    private Float intRate;    // 이자율
    private String repayOrgCode;    // 상환기관 (코드)
    private String repayAccountNum;    // 상환계좌번호
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardLoanStEntity getEntity(){
        CardLoanStEntity entity = new CardLoanStEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setLoanDtime(loanDtime);
        entity.setLoanAmt(loanAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setPayDueDate(payDueDate);
        entity.setIntRate(intRate);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
