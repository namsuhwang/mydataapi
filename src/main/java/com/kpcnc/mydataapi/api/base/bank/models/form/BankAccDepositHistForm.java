package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccDepositHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccDepositHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형 (코드)
    private String transClass;    // 거래구분
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private Integer paidInCnt;    // 납입회차
    private String transMemo;    // 적요

    public BankAccDepositHistEntity getEntity(){
        BankAccDepositHistEntity entity = new BankAccDepositHistEntity();
        entity.setMemberId(this.getMemberId());
        entity.setOrgCd(this.getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransClass(transClass);
        entity.setCurrencyCode(currencyCode);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setPaidInCnt(paidInCnt);
        entity.setTransMemo(transMemo);
        entity.setApiTranDay(this.getApiTranDay());
        entity.setApiTranId(this.getApiTranId());
        entity.setRegUserId(this.getRegUserId());
        entity.setRegDt(this.getRegDt());
        entity.setChgUserId(this.getChgUserId());
        entity.setChgDt(this.getChgDt());
        return entity;
    }
}
