package com.albee.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ppay002ResDto extends ResBaseDto {

    private String totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정

    public PpayBalForm getForm(FormBase formBase, String ppId){
        PpayBalForm form = new PpayBalForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setPpId(ppId);
        form.setTotalBalanceAmt(totalBalanceAmt);
        form.setChargeBalanceAmt(chargeBalanceAmt);
        form.setReserveBalanceAmt(reserveBalanceAmt);
        form.setReserveDueAmt(reserveDueAmt);
        form.setExpDueAmt(expDueAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
