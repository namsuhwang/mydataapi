package com.kpcnc.mydataapi.api.load.irp.models.form;

import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private BigDecimal accumAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private BigDecimal employerAmt;    // 사용자부담금
    private BigDecimal employeeAmt;    // 가입자부담금
    private String issueDate;    // 개설일
    private String firstDepositDate;    // 최초입금일
    private String regDate;    // 최초 제도 가입일
    private String rcvStartDate;    // 연금개시 시작(예정)일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public IrpAccBaseEntity getEntity(){
        IrpAccBaseEntity entity = new IrpAccBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setAccumAmt(accumAmt);
        entity.setEvalAmt(evalAmt);
        entity.setEmployerAmt(employerAmt);
        entity.setEmployeeAmt(employeeAmt);
        entity.setIssueDate(issueDate);
        entity.setFirstDepositDate(firstDepositDate);
        entity.setRegDate(regDate);
        entity.setRcvStartDate(rcvStartDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
