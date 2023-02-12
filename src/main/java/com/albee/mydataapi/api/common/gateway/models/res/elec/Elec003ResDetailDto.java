package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Elec003ResDetailDto {

    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)
    private String chargeAccountNum;    // 충전지불수단 식별키
    private String chargeOption;    // 충전조건 (코드)
    private String chargeDay;    // 기준날짜
    private BigDecimal chargeBaseAmt;    // 기준금액
    private BigDecimal chargeAmt;    // 충전금액

    public ElecPpayAutoChargeForm getForm(FormBase formBase, String fobId, String accountId){
        ElecPpayAutoChargeForm form = new ElecPpayAutoChargeForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setFobId(fobId);
        form.setAccountId(accountId);
        form.setAutoChargeSeq(autoChargeSeq);
        form.setChargeOrgCode(chargeOrgCode);
        form.setChargeAccountNum(chargeAccountNum);
        form.setChargeOption(chargeOption);
        form.setChargeDay(chargeDay);
        form.setChargeBaseAmt(chargeBaseAmt);
        form.setChargeAmt(chargeAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
