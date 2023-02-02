package com.albee.mydataapi.api.base.invt.models.form;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccProdForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String prodType;    // 상품종류 (코드)
    private String prodTypeDetail;    // 상품종류 상세
    private String prodCode;    // 종목코드 (상품코드)
    private String exCode;    // 거래소 코드
    private String prodName;    // 종목명
    private String posType;    // 파생상품포지 션구분(코드)
    private String creditType;    // 신용구분 (코드)
    private String isTaxBenefits;    // 세제혜택 적용여부(상품)
    private BigDecimal purchaseAmt;    // 매입금액
    private BigDecimal holdingNum;    // 보유수량
    private String transUnit;    // 수량단위명
    private BigDecimal evalAmt;    // 평가금액
    private String isExecution;    // 체결기준여부
    private String currencyCode;    // 통화코드

    public InvtAccProdEntity getEntity(){
        InvtAccProdEntity entity = new InvtAccProdEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setProdType(prodType);
        entity.setProdTypeDetail(prodTypeDetail);
        entity.setProdCode(prodCode);
        entity.setExCode(exCode);
        entity.setProdName(prodName);
        entity.setPosType(posType);
        entity.setCreditType(creditType);
        entity.setIsTaxBenefits(isTaxBenefits);
        entity.setPurchaseAmt(purchaseAmt);
        entity.setHoldingNum(holdingNum);
        entity.setTransUnit(transUnit);
        entity.setEvalAmt(evalAmt);
        entity.setIsExecution(isExecution);
        entity.setCurrencyCode(currencyCode);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
