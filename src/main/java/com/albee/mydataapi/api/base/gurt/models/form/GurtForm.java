package com.albee.mydataapi.api.base.gurt.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtForm extends FormBase {
    private String insuNum;    // 증권번호
    private String isConsent;    // 전송요구 여부
    private String prodName;    // 상품명
    private String insuType;    // 보험종류 구분(코드)
    private String insuStatus;    // 계약상태 (코드)

    public GurtEntity getEntity(){
        GurtEntity entity = new GurtEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setIsConsent(isConsent);
        entity.setProdName(prodName);
        entity.setInsuType(insuType);
        entity.setInsuStatus(insuStatus);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
