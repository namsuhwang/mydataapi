package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Elec002ResDto extends ResBaseDto {

    private BigDecimal totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal withdrawableAmt;    // 출금 가능액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정

    public ElecPpayBalForm getForm(FormBase formBase, String fobId, String accountId){
        ElecPpayBalForm form = new ElecPpayBalForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setFobId(fobId);
        form.setAccountId(accountId);
        form.setTotalBalanceAmt(totalBalanceAmt);
        form.setChargeBalanceAmt(chargeBalanceAmt);
        form.setReserveBalanceAmt(reserveBalanceAmt);
        form.setWithdrawableAmt(withdrawableAmt);
        form.setReserveDueAmt(reserveDueAmt);
        form.setExpDueAmt(expDueAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
