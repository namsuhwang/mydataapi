package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiHistForm extends FormBase {
    private String insuNum;    // 증권번호
    private String transDate;    // 납입일자
    private Integer transAppliedMonth;    // 납입연월
    private Integer paidInCnt;    // 납입회차
    private BigDecimal paidAmt;    // 실납입 보험료
    private String currencyCode;    // 통화코드(실 납입 보험료)
    private String payMethod;    // 수금방법 (코드)

    public InsuMiHistEntity getEntity(){
        InsuMiHistEntity entity = new InsuMiHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setTransDate(transDate);
        entity.setTransAppliedMonth(transAppliedMonth);
        entity.setPaidInCnt(paidInCnt);
        entity.setPaidAmt(paidAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setPayMethod(payMethod);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
