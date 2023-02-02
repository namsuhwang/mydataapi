package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String currencyCode;    // 통화코드(대 출원금상환액 및 이자납입액)
    private BigDecimal loanPaidAmt;    // 대출원금상환 액
    private BigDecimal intPaidAmt;    // 이자납입액
    private Integer intCnt;    // 이자적용수

    public InsuLoanHistEntity getEntity(){
        InsuLoanHistEntity entity = new InsuLoanHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setTransNo(transNo);
        entity.setTransDtime(transDtime);
        entity.setCurrencyCode(currencyCode);
        entity.setLoanPaidAmt(loanPaidAmt);
        entity.setIntPaidAmt(intPaidAmt);
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
