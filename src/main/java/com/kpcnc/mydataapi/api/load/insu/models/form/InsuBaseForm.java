package com.kpcnc.mydataapi.api.load.insu.models.form;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuBaseForm{
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
    private String pensionRcvStartDate;    // 연금개시일
    private String pensionRcvCycle;    // 연금수령주기
    private String isLoanable;    // 대출실행 가능 상품 여부
    private Integer insuredCnt;    // 피보험자수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuBaseEntity getEntity(){
        InsuBaseEntity entity = new InsuBaseEntity();
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
        entity.setPensionRcvStartDate(pensionRcvStartDate);
        entity.setPensionRcvCycle(pensionRcvCycle);
        entity.setIsLoanable(isLoanable);
        entity.setInsuredCnt(insuredCnt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
