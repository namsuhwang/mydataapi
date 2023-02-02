package com.albee.mydataapi.api.base.elec.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayForm extends FormBase {
    private String fobId;    // 권면 ID
    private String fobName;    // 권면명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 가입일자
    private Integer limitAmt;    // 권면한도
    private String isCharge;    // 자동충전 등록 여부
    private String isWithdrawable;    // 출금 가능 여부
    private Integer currencyCode;    // 통화코드
    private Integer accountCnt;    // 계정수

    public ElecPpayEntity getEntity(){
        ElecPpayEntity entity = new ElecPpayEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setFobId(fobId);
        entity.setFobName(fobName);
        entity.setIsConsent(isConsent);
        entity.setRegDate(regDate);
        entity.setLimitAmt(limitAmt);
        entity.setIsCharge(isCharge);
        entity.setIsWithdrawable(isWithdrawable);
        entity.setCurrencyCode(currencyCode);
        entity.setAccountCnt(accountCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
