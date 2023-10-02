package com.albee.mydataapi.api.base.tele.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleContForm extends FormBase {
    private String mgmtId;    // 계약관리번호
    private String isConsent;    // 전송요구 여부
    private String telecomNum;    // 가입번호
    private String type;    // 통신구분 (코드)
    private String status;    // 가입구분 (코드)

    public TeleContEntity getEntity(){
        TeleContEntity entity = new TeleContEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setMgmtId(mgmtId);
        entity.setIsConsent(isConsent);
        entity.setTelecomNum(telecomNum);
        entity.setType(type);
        entity.setStatus(status);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
