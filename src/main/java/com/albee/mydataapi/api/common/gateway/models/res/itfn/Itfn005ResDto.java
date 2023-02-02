package com.albee.mydataapi.api.common.gateway.models.res.itfn;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Itfn005ResDto extends ResBaseDto {

    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)
    private String nextRepayDate;    // 다음 납일 예정일

    public ItfnLeaseForm getForm(FormBase formBase, String accountNum, String seqno){
        ItfnLeaseForm form = new ItfnLeaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setIssueDate(issueDate);
        form.setExpDate(expDate);
        form.setRepayDate(repayDate);
        form.setRepayMethod(repayMethod);
        form.setRepayOrgCode(repayOrgCode);
        form.setRepayAccountNum(repayAccountNum);
        form.setNextRepayDate(nextRepayDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
