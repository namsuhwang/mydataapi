package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiSccontForm extends FormBase {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험인/물 번호
    private String contractName;    // 특약명
    private String contractStatus;    // 특약의 상태 (코드)
    private String contractExpDate;    // 특약만기일자
    private BigDecimal contractFaceAmt;    // 특약가입금액
    private String currencyCode;    // 통화코드(특 약가입금액)
    private String isRequired;    // 특약의 유형 (여부)

    public InsuMiSccontEntity getEntity(){
        InsuMiSccontEntity entity = new InsuMiSccontEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setInsuredNo(insuredNo);
        entity.setContractName(contractName);
        entity.setContractStatus(contractStatus);
        entity.setContractExpDate(contractExpDate);
        entity.setContractFaceAmt(contractFaceAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setIsRequired(isRequired);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
