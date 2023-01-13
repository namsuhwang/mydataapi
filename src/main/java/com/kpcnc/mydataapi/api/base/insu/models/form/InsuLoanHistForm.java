package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String currencyCode;    // 통화코드(대 출원금상환액 및 이자납입액)
    private BigDecimal loanPaidAmt;    // 대출원금상환 액
    private BigDecimal intPaidAmt;    // 이자납입액
    private Integer intCnt;    // 이자적용수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuLoanHistEntity getEntity(){
        InsuLoanHistEntity entity = new InsuLoanHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setAccountNum(accountNum);
        entity.setTransNo(transNo);
        entity.setTransDtime(transDtime);
        entity.setCurrencyCode(currencyCode);
        entity.setLoanPaidAmt(loanPaidAmt);
        entity.setIntPaidAmt(intPaidAmt);
        entity.setIntCnt(intCnt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
