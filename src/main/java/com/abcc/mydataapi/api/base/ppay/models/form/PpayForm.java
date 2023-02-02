package com.abcc.mydataapi.api.base.ppay.models.form;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayForm extends FormBase {
    private String ppId;    // 선불카드 식별자
    private String ppName;    // 선불카드 상품명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 발급일자
    private Integer limitAmt;    // 액면한도 또는 최대충전한도

    public PpayEntity getEntity(){
        PpayEntity entity = new PpayEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setPpId(ppId);
        entity.setPpName(ppName);
        entity.setIsConsent(isConsent);
        entity.setRegDate(regDate);
        entity.setLimitAmt(limitAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
