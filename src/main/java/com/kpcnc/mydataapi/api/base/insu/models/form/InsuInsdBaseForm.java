package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String isRenewable;    // 갱신여부 (여부)
    private String issueDate;    // 계약체결일
    private String expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private String isVariable;    // 변액보험 여부
    private String isUniversal;    // 유니버셜 여부
    private String issuerName;    // 계약자명
    private String isPrimary;    // 주피보험자 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuInsdBaseEntity getEntity(){
        InsuInsdBaseEntity entity = new InsuInsdBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setIsRenewable(isRenewable);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setFaceAmt(faceAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setIsVariable(isVariable);
        entity.setIsUniversal(isUniversal);
        entity.setIssuerName(issuerName);
        entity.setIsPrimary(isPrimary);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
