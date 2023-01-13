package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String loanStartDate;    // 대출일
    private String loanExpDate;    // 만기일
    private String repayMethod;    // 상환방식(코드)
    private String insuNum;    // 증권번호
    private String repayOrgCode;    // 납입기관(코 드)
    private String repayAccountNum;    // 납입 계좌번호 (자동이체)
    private String repayDate;    // 월상환일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuLoanBaseEntity getEntity(){
        InsuLoanBaseEntity entity = new InsuLoanBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setLoanStartDate(loanStartDate);
        entity.setLoanExpDate(loanExpDate);
        entity.setRepayMethod(repayMethod);
        entity.setInsuNum(insuNum);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setRepayDate(repayDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
