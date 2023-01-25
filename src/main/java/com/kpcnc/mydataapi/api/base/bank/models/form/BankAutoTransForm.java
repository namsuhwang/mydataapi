package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAutoTransForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String scheduledOrgCode;    // 지동이체 기관(코드)
    private String scheduledAccountNum;    // 자동이체계좌 번호
    private BigDecimal scheduledAmt;    // 자동이체금액
    private String scheduledCycle;    // 자동이체주기
    private String scheduledDate;    // 자동이체주기 상세
    private String transMemo;    // 적요
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAutoTransForm(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public BankAutoTransEntity getEntity(){
        BankAutoTransEntity entity = new BankAutoTransEntity();
        entity.setMemberId(this.getMemberId());
        entity.setOrgCd(this.getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setScheduledOrgCode(scheduledOrgCode);
        entity.setScheduledAccountNum(scheduledAccountNum);
        entity.setScheduledAmt(scheduledAmt);
        entity.setScheduledCycle(scheduledCycle);
        entity.setScheduledDate(scheduledDate);
        entity.setTransMemo(transMemo);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
