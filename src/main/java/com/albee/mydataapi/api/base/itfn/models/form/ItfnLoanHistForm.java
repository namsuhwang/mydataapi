package com.albee.mydataapi.api.base.itfn.models.form;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLoanHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 대출잔액
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal retIntAmt;    // 환출이자
    private Integer intCnt;    // 이자적용수

    public ItfnLoanHistEntity getEntity(){
        ItfnLoanHistEntity entity = new ItfnLoanHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setCurrencyCode(currencyCode);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setIntAmt(intAmt);
        entity.setRetIntAmt(retIntAmt);
        entity.setIntCnt(intCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
