package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiBasePpForm extends FormBase {
    private String insuNum;    // 증권번호
    private String isPerson;    // 인/물 구분코드
    private String prizeNum;    // 피보험인/물 번호
    private String prizeName;    // 피보험인/물 명
    private String isPrimary;    // 주피보험자 여부
    private String prizeAddr;    // 소재지
    private String objectCode;    // 물건구분 (코드)
    private String prizeCode;    // 목적물(코드)

    public InsuMiBasePpEntity getEntity(){
        InsuMiBasePpEntity entity = new InsuMiBasePpEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setIsPerson(isPerson);
        entity.setPrizeNum(prizeNum);
        entity.setPrizeName(prizeName);
        entity.setIsPrimary(isPrimary);
        entity.setPrizeAddr(prizeAddr);
        entity.setObjectCode(objectCode);
        entity.setPrizeCode(prizeCode);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
