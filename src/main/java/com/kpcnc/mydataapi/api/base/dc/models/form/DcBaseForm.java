package com.kpcnc.mydataapi.api.base.dc.models.form;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String dcNum;    // 상품관리번호
    private BigDecimal balanceAmt;    // 계좌잔액
    private BigDecimal evalAmt;    // 계좌평가금액
    private String issueDate;    // 개설일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public DcBaseEntity getEntity(){
        DcBaseEntity entity = new DcBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setDcNum(dcNum);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setIssueDate(issueDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
