package com.abcc.mydataapi.api.base.bank.models.form;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccFundHistEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형 (코드)
    private String currencyCode;    // 통화코드
    private BigDecimal baseAmt;    // 기준가
    private BigDecimal transFundNum;    // 거래좌수
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔고평가금액

    public BankAccFundHistEntity getEntity(){
        BankAccFundHistEntity entity = new BankAccFundHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setCurrencyCode(currencyCode);
        entity.setBaseAmt(baseAmt);
        entity.setTransFundNum(transFundNum);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
