package com.abcc.mydataapi.api.base.itfn.models.form;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLeaseForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)
    private String nextRepayDate;    // 다음 납일 예정일

    public ItfnLeaseEntity getEntity(){
        ItfnLeaseEntity entity = new ItfnLeaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setRepayDate(repayDate);
        entity.setRepayMethod(repayMethod);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setNextRepayDate(nextRepayDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
