package com.albee.mydataapi.api.base.elec.models.form;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayAutoChargeForm extends FormBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)
    private String chargeAccountNum;    // 충전지불수단 식별키
    private String chargeOption;    // 충전조건 (코드)
    private String chargeDay;    // 기준날짜
    private BigDecimal chargeBaseAmt;    // 기준금액
    private BigDecimal chargeAmt;    // 충전금액

    public ElecPpayAutoChargeEntity getEntity(){
        ElecPpayAutoChargeEntity entity = new ElecPpayAutoChargeEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setAutoChargeSeq(autoChargeSeq);
        entity.setChargeOrgCode(chargeOrgCode);
        entity.setChargeAccountNum(chargeAccountNum);
        entity.setChargeOption(chargeOption);
        entity.setChargeDay(chargeDay);
        entity.setChargeBaseAmt(chargeBaseAmt);
        entity.setChargeAmt(chargeAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
