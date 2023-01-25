package com.kpcnc.mydataapi.api.base.bank.models;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAutoTransEntity;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAutoTransForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
public class BankAutoTransSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String scheduledOrgCode;    // 지동이체 기관(코드)
    private String scheduledAccountNum;    // 자동이체계좌 번호
    private BigDecimal scheduledAmt;    // 자동이체금액
    private String scheduledCycle;    // 자동이체주기
    private String scheduledDate;    // 자동이체주기 상세

    public BankAutoTransSearch(String memberId, String orgCd, String accountNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
    }

    public BankAutoTransSearch(String memberId, String orgCd, String accountNum, String scheduledOrgCode, String scheduledAccountNum, BigDecimal scheduledAmt, String scheduledCycle, String scheduledDate) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.accountNum = accountNum;
        this.scheduledOrgCode = scheduledOrgCode;
        this.scheduledAccountNum = scheduledAccountNum;
        this.scheduledAmt = scheduledAmt;
        this.scheduledCycle = scheduledCycle;
        this.scheduledDate = scheduledDate;
    }

    public BankAutoTransSearch(BankAutoTransEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.accountNum = entity.getAccountNum();
        this.scheduledOrgCode = entity.getScheduledOrgCode();
        this.scheduledAccountNum = entity.getScheduledAccountNum();
        this.scheduledAmt = entity.getScheduledAmt();
        this.scheduledCycle = entity.getScheduledCycle();
        this.scheduledDate = entity.getScheduledDate();
    }

    public BankAutoTransSearch(BankAutoTransForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.accountNum = form.getAccountNum();
        this.scheduledOrgCode = form.getScheduledOrgCode();
        this.scheduledAccountNum = form.getScheduledAccountNum();
        this.scheduledAmt = form.getScheduledAmt();
        this.scheduledCycle = form.getScheduledCycle();
        this.scheduledDate = form.getScheduledDate();
    }
}
