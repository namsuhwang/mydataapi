package com.kpcnc.mydataapi.api.load.itfn.models.form;

import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLeaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLeaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String issueDate;    // 대출일
    private String expDate;    // 만기일
    private String repayDate;    // 월상환일
    private String repayMethod;    // 상환방식 (코드)
    private String repayOrgCode;    // 자동이체 기관 (코드)
    private String repayAccountNum;    // 상환계좌번호 (자동이체)
    private String nextRepayDate;    // 다음 납일 예정일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ItfnLeaseEntity getEntity(){
        ItfnLeaseEntity entity = new ItfnLeaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setRepayDate(repayDate);
        entity.setRepayMethod(repayMethod);
        entity.setRepayOrgCode(repayOrgCode);
        entity.setRepayAccountNum(repayAccountNum);
        entity.setNextRepayDate(nextRepayDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
