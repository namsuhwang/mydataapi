package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuPayForm extends FormBase {
    private String insuNum;    // 증권번호
    private String payDue;    // 납입기간구분 (코드)
    private String payCycle;    // 납입주기 (코드)
    private Integer payCnt;    // 총 납입 횟수
    private String payOrgCode;    // 납입기관(코 드)
    private String payAccountNum;    // 납입 계좌번호 (자동이체)
    private String payDate;    // 납입일자
    private String payEndDate;    // 납입종료일자
    private BigDecimal payAmt;    // 납입 보험료
    private String currencyCode;    // 통화코드(납 입 보험료)
    private String isAutoPay;    // 자동대출납입 신청 여부

    public InsuPayEntity getEntity(){
        InsuPayEntity entity = new InsuPayEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
