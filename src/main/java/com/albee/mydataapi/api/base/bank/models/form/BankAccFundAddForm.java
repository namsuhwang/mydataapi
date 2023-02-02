package com.albee.mydataapi.api.base.bank.models.form;

import com.albee.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccFundAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 잔액
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 투자원금
    private BigDecimal fundNum;    // 보유좌수

    public BankAccFundAddForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccFundAddEntity getEntity(){
        BankAccFundAddEntity entity = new BankAccFundAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setInvPrincipal(invPrincipal);
        entity.setFundNum(fundNum);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
