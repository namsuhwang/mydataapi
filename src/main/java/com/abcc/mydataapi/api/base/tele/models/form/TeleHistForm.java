package com.abcc.mydataapi.api.base.tele.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleHistForm extends FormBase {
    private String mgmtId;    // 계약관리번호
    private String transMonth;    // 납부연월
    private BigDecimal paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)

    public TeleHistEntity getEntity(){
        TeleHistEntity entity = new TeleHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setMgmtId(mgmtId);
        entity.setTransMonth(transMonth);
        entity.setPaidAmt(paidAmt);
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
