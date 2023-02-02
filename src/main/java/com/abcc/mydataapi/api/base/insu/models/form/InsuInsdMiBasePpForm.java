package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdMiBasePpForm extends FormBase {
    private String insuNum;    // 증권번호
    private String prizeNum;    // 피보험인/물 번호
    private String isPerson;    // 인/물 구분코드
    private String prizeName;    // 피보험인/물 명
    private String isPrimary;    // 주피보험자 여부
    private String prizeAddr;    // 소재지
    private String objectCode;    // 물건구분 (코드)
    private String prizeCode;    // 목적물(코드)

    public InsuInsdMiBasePpEntity getEntity(){
        InsuInsdMiBasePpEntity entity = new InsuInsdMiBasePpEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setPrizeNum(prizeNum);
        entity.setIsPerson(isPerson);
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
