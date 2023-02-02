package com.abcc.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
