package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu022ResDetailDto {

    private String prizeNum;    // 피보험인/물 번호
    private String isPerson;    // 인/물 구분코드
    private String prizeName;    // 피보험인/물 명
    private Boolean isPrimary;    // 주피보험자 여부
    private String prizeAddr;    // 소재지
    private String objectCode;    // 물건구분 (코드)
    private String prizeCode;    // 목적물(코드)


    public InsuInsdMiBasePpForm getForm(FormBase formBase, String insuNum){
        InsuInsdMiBasePpForm form = new InsuInsdMiBasePpForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setPrizeNum(prizeNum);
        form.setIsPerson(isPerson);
        form.setPrizeName(prizeName);
        form.setIsPrimary(isPrimary ? "Y" : "N");
        form.setPrizeAddr(prizeAddr);
        form.setObjectCode(objectCode);
        form.setPrizeCode(prizeCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
