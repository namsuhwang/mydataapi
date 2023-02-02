package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdMiBaseForm extends FormBase {
    private String insuNum;    // 증권번호
    private String isRenewable;    // 갱신여부 (여부)
    private Integer issueDate;    // 계약체결일
    private Integer expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private String contractorName;    // 계약자명
    private Integer prizeCnt;    // 목적물수

    public InsuInsdMiBaseEntity getEntity(){
        InsuInsdMiBaseEntity entity = new InsuInsdMiBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setIsRenewable(isRenewable);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setFaceAmt(faceAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setContractorName(contractorName);
        entity.setPrizeCnt(prizeCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
