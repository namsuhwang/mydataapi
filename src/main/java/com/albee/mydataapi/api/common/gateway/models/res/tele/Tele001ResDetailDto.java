package com.albee.mydataapi.api.common.gateway.models.res.tele;

import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tele001ResDetailDto {

    private String mgmtId;    // 계약관리번호
    private Boolean isConsent;    // 전송요구 여부
    private String telecomNum;    // 가입번호
    private String type;    // 통신구분 (코드)
    private String status;    // 가입구분 (코드)

    public TeleContForm getForm(FormBase formBase){
        TeleContForm form = new TeleContForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setMgmtId(mgmtId);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setTelecomNum(telecomNum);
        form.setType(type);
        form.setStatus(status);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
