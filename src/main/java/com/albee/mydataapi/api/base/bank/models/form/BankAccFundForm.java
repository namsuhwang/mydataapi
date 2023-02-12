package com.albee.mydataapi.api.base.bank.models.form;

import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String standardFundCode;    // 표준펀드코드
    private String paidInType;    // 납입유형 (코드)
    private String issueDate;    // 개설일
    private String expDate;    // 만기일

    public BankAccFundForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccFundEntity getEntity(){
        BankAccFundEntity entity = new BankAccFundEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setStandardFundCode(standardFundCode);
        entity.setPaidInType(paidInType);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
