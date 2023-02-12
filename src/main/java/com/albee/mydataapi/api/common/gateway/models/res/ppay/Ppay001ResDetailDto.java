package com.albee.mydataapi.api.common.gateway.models.res.ppay;

import com.albee.mydataapi.api.base.ppay.models.form.PpayForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ppay001ResDetailDto {

    private String ppId;    // 선불카드
    private String ppName;    // 선불카드 상품명
    private Boolean isConsent;    // 전송요구 여부
    private String regDate;    // 발급일자
    private Integer limitAmt;    // 액면한도 또는 최대충전한도

    public PpayForm getForm(FormBase formBase){
        PpayForm form = new PpayForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setPpId(ppId);
        form.setPpName(ppName);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setRegDate(regDate);
        form.setLimitAmt(limitAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
