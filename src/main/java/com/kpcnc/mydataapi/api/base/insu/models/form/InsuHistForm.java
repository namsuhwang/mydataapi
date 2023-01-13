package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String transDate;    // 납입일자
    private Integer transAppliedMonth;    // 납입연월
    private Integer paidInCnt;    // 납입회차
    private BigDecimal paidAmt;    // 실납입 보험료
    private String currencyCode;    // 통화코드(실 납입 보험료)
    private String payMethod;    // 수금방법 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuHistEntity getEntity(){
        InsuHistEntity entity = new InsuHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setTransDate(transDate);
        entity.setTransAppliedMonth(transAppliedMonth);
        entity.setPaidInCnt(paidInCnt);
        entity.setPaidAmt(paidAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setPayMethod(payMethod);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}