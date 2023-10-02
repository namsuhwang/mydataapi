package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Elec001ResDetailDto {

    private String fobId;    // 권면 ID
    private String fobName;    // 권면명
    private Boolean isConsent;    // 전송요구 여부
    private String regDate;    // 가입일자
    private Integer limitAmt;    // 권면한도
    private Boolean isCharge;    // 자동충전 등록 여부
    private Boolean isWithdrawable;    // 출금 가능 여부
    private Integer currencyCode;    // 통화코드

    @JsonProperty("account_cnt")
    private Integer listCnt;

    @JsonProperty("account_list")
    private List<Elec001ResDetailAccountDto> list;

    public ElecPpayForm getForm(FormBase formBase){
        ElecPpayForm form = new ElecPpayForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setFobId(fobId);
        form.setFobName(fobName);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setRegDate(regDate);
        form.setLimitAmt(limitAmt);
        form.setIsCharge(isCharge ? "Y" : "N");
        form.setIsWithdrawable(isWithdrawable ? "Y" : "N");
        form.setCurrencyCode(currencyCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
