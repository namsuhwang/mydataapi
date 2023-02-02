package com.abcc.mydataapi.api.common.gateway.models.res.invt;

import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Invt004ResDetailDto {

    private String prodType;    // 상품종류 (코드)
    private String prodTypeDetail;    // 상품종류 상세
    private String prodCode;    // 종목코드 (상품코드)
    private String exCode;    // 거래소 코드
    private String prodName;    // 종목명
    private String posType;    // 파생상품포지 션구분(코드)
    private String creditType;    // 신용구분 (코드)
    private Boolean isTaxBenefits;    // 세제혜택 적용여부(상품)
    private BigDecimal purchaseAmt;    // 매입금액
    private BigDecimal holdingNum;    // 보유수량
    private String transUnit;    // 수량단위명
    private BigDecimal evalAmt;    // 평가금액
    private Boolean isExecution;    // 체결기준여부
    private String currencyCode;    // 통화코드

    public InvtAccProdForm getForm(FormBase formBase, String accountNum){
        InvtAccProdForm form = new InvtAccProdForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setProdType(prodType);
        form.setProdTypeDetail(prodTypeDetail);
        form.setProdCode(prodCode);
        form.setExCode(exCode);
        form.setProdName(prodName);
        form.setPosType(posType);
        form.setCreditType(creditType);
        form.setIsTaxBenefits(isTaxBenefits ? "Y" : "N");
        form.setPurchaseAmt(purchaseAmt);
        form.setHoldingNum(holdingNum);
        form.setTransUnit(transUnit);
        form.setEvalAmt(evalAmt);
        form.setIsExecution(isExecution ? "Y" : "N");
        form.setCurrencyCode(currencyCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
