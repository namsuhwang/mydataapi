package com.abcc.mydataapi.api.base.bank.models.form;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccProdHistEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccProdHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래구분(코드)
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액

    public BankAccProdHistEntity getEntity(){
        BankAccProdHistEntity entity = new BankAccProdHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setCurrencyCode(currencyCode);
        entity.setTransAmt(transAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
