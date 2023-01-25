package com.kpcnc.mydataapi.api.common.gateway.models.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccLoanHistForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank010ResDetailDto {
    private String transDtime;
    private String transNo;
    private String transType;
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 대출잔액
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal retIntAmt;    // 환출이자

    @JsonProperty("int_cnt")
    private Integer listCnt;

    @JsonProperty("int_list")
    private List<Bank010ResDetailIntDto> list;

    public BankAccLoanHistForm getForm(FormBase formBase, String accountNum, String seqno){
        BankAccLoanHistForm form = new BankAccLoanHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setSeqno(seqno);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransType(transType);
        form.setCurrencyCode(currencyCode);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setPrincipalAmt(principalAmt);
        form.setIntAmt(intAmt);
        form.setRetIntAmt(retIntAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
