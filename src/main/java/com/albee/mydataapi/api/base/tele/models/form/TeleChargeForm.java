package com.albee.mydataapi.api.base.tele.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleChargeForm extends FormBase {
    private String mgmtId;    // 계약관리번호
    private String chargeMonth;    // 청구년월
    private BigDecimal chargeAmt;    // 청구금액
    private String chargeDate;    // 납부예정일자

    public TeleChargeEntity getEntity(){
        TeleChargeEntity entity = new TeleChargeEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setMgmtId(mgmtId);
        entity.setChargeMonth(chargeMonth);
        entity.setChargeAmt(chargeAmt);
        entity.setChargeDate(chargeDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
