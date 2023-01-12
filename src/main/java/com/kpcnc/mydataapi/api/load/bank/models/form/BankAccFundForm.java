package com.kpcnc.mydataapi.api.load.bank.models.form;

import com.kpcnc.mydataapi.api.load.bank.models.entity.BankAccFundEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String standardFundCode;    // 표준펀드코드
    private String paidInType;    // 납입유형 (코드)
    private String issueDate;    // 개설일
    private String expDate;    // 만기일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAccFundEntity getEntity(){
        BankAccFundEntity entity = new BankAccFundEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setStandardFundCode(standardFundCode);
        entity.setPaidInType(paidInType);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
