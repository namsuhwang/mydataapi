package com.kpcnc.mydataapi.api.load.insu.models.form;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiPayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiPayForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String payDue;    // 납입기간구분 (코드)
    private String payCycle;    // 납입주기 (코드)
    private Integer payCnt;    // 총 납입 횟수
    private String payOrgCode;    // 납입기관(코 드)
    private String payAccountNum;    // 납입 계좌번호(자동이체)
    private String payDate;    // 납입일자
    private String payEndDate;    // 납입종료일자
    private BigDecimal payAmt;    // 납입 보험료
    private String currencyCode;    // 통화코드(납 입 보험료)
    private String isAutoPay;    // 자동대출납입 신청 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuMiPayEntity getEntity(){
        InsuMiPayEntity entity = new InsuMiPayEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setInsuNum(insuNum);
        entity.setPayDue(payDue);
        entity.setPayCycle(payCycle);
        entity.setPayCnt(payCnt);
        entity.setPayOrgCode(payOrgCode);
        entity.setPayAccountNum(payAccountNum);
        entity.setPayDate(payDate);
        entity.setPayEndDate(payEndDate);
        entity.setPayAmt(payAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setIsAutoPay(isAutoPay);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
