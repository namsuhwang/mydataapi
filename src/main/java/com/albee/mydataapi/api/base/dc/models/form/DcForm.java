package com.albee.mydataapi.api.base.dc.models.form;

import com.albee.mydataapi.api.base.dc.models.entity.DcEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcForm extends FormBase {
    private String dcNum;    // 상품관리번호
    private String dcName;    // 상품명
    private String isConsent;    // 전송요구 여부

    public DcEntity getEntity(){
        DcEntity entity = new DcEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setDcNum(dcNum);
        entity.setDcName(dcName);
        entity.setIsConsent(isConsent);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
