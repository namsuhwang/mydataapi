package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdSccontForm extends FormBase {
    private String insuNum;    // 증권번호
    private String contractName;    // 특약명
    private String contractStatus;    // 특약의 상태 (코드)
    private String contractExpDate;    // 특약만기일자
    private BigDecimal contractFaceAmt;    // 특약가입금액
    private String currencyCode;    // 통화코드(특약가입금액)
    private String isRequired;    // 특약의 유형 (여부)

    public InsuInsdSccontEntity getEntity(){
        InsuInsdSccontEntity entity = new InsuInsdSccontEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
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
