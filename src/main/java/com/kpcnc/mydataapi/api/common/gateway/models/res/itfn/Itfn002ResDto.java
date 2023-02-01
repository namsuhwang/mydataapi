package com.kpcnc.mydataapi.api.common.gateway.models.res.itfn;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccFundForm;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Itfn002ResDto extends ResBaseDto {

    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private Float lastOfferedRate;    // 최종적용금리
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관(코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)

    public ItfnLoanForm getForm(FormBase formBase, String accountNum, String seqno){
        ItfnLoanForm form = new ItfnLoanForm();
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
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
