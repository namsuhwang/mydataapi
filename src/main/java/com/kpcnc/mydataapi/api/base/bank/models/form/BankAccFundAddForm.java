package com.kpcnc.mydataapi.api.base.bank.models.form;

import com.kpcnc.mydataapi.api.base.bank.models.entity.BankAccFundAddEntity;
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
public class BankAccFundAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String currencyCode;    // 통화코드
    private BigDecimal balanceAmt;    // 잔액
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 투자원금
    private BigDecimal fundNum;    // 보유좌수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BankAccFundAddForm(String memberId, String orgCd, String accountNum, String seqno) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
        this.seqno = seqno;
    }

    public BankAccFundAddEntity getEntity(){
        BankAccFundAddEntity entity = new BankAccFundAddEntity();
        entity.setMemberId(this.getMemberId());
        entity.setOrgCd(this.getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setCurrencyCode(currencyCode);
        entity.setBalanceAmt(balanceAmt);
        entity.setEvalAmt(evalAmt);
        entity.setInvPrincipal(invPrincipal);
        entity.setFundNum(fundNum);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
