package com.kpcnc.mydataapi.api.base.ppay.models.form;

import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayBalForm extends FormBase {
    private String ppId;    // 선불카드 식별자
    private String totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정

    public PpayBalEntity getEntity(){
        PpayBalEntity entity = new PpayBalEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setPpId(ppId);
        entity.setTotalBalanceAmt(totalBalanceAmt);
        entity.setChargeBalanceAmt(chargeBalanceAmt);
        entity.setReserveBalanceAmt(reserveBalanceAmt);
        entity.setReserveDueAmt(reserveDueAmt);
        entity.setExpDueAmt(expDueAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
