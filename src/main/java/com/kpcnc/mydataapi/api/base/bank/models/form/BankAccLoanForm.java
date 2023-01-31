package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccLoanEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccLoanForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private Float lastOfferedRate;    // 최종적용금리
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)
    private String unredeemedStart;    // 거치기간 시작연월
    private String unredeemedEnd;    // 거치기간 종료연월

    public BankAccLoanForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccLoanEntity getEntity(){
        BankAccLoanEntity entity = new BankAccLoanEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setLastOfferedRate(lastOfferedRate);
        entity.setRepayDate(repayDate);
        entity.setRepayMethod(repayMethod);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setUnredeemedStart(unredeemedStart);
        entity.setUnredeemedEnd(unredeemedEnd);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
