package com.albee.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.bank.models.form.BankAccLoanForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Bank008ResDto extends ResBaseDto {
    private String issueDate;   // 개설일

    private String expDate;   // 만기일

    private Float lastOfferedRate;    // 최종적용금리

    private String repayDate;    // 월상환일

    private String repayMethod;    // 상환방식(코드)

    private String repayOrgCode;    // 자동이체 기관(코드)

    private String repayAccountNum;    // 상환계좌번호(자동이체)

    private String unredeemedStart;    // 거치기간 시작연월

    private String unredeemedEnd;    // 거치기간 종료연월


    public BankAccLoanForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccLoanForm form = new BankAccLoanForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setLastOfferedRate(lastOfferedRate);
        form.setRepayDate(repayDate);
        form.setRepayMethod(repayMethod);
        form.setRepayOrgCode(repayOrgCode);
        form.setRepayAccountNum(repayAccountNum);
        form.setUnredeemedStart(unredeemedStart);
        form.setUnredeemedEnd(unredeemedEnd);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
