package com.abcc.mydataapi.api.base.elec.models.form;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayBalForm extends FormBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private BigDecimal totalBalanceAmt;    // 총잔액
    private BigDecimal chargeBalanceAmt;    // 충전포인트 잔액
    private BigDecimal reserveBalanceAmt;    // 적립포인트 잔액
    private BigDecimal withdrawableAmt;    // 출금 가능액
    private BigDecimal reserveDueAmt;    // 적립예정
    private BigDecimal expDueAmt;    // 소멸예정

    public ElecPpayBalEntity getEntity(){
        ElecPpayBalEntity entity = new ElecPpayBalEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setTotalBalanceAmt(totalBalanceAmt);
        entity.setChargeBalanceAmt(chargeBalanceAmt);
        entity.setReserveBalanceAmt(reserveBalanceAmt);
        entity.setWithdrawableAmt(withdrawableAmt);
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
