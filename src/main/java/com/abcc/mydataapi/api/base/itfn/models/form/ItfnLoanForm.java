package com.abcc.mydataapi.api.base.itfn.models.form;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLoanForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private Float lastOfferedRate;    // 최종적용금리
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관(코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)

    public ItfnLoanEntity getEntity(){
        ItfnLoanEntity entity = new ItfnLoanEntity();
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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
