package com.albee.mydataapi.api.common.gateway.models.res.invt;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Invt003ResDetailDto {

    private String transDtime;    // 거래일시 또는 거래일자
    private String prodName;    // 종목명(상품명)
    private String prodCode;    // 종목코드(상품 코드)
    private String transNo;    // 거래번호
    private String transType;    // 거래종류 (코드)
    private String transTypeDetail;    // 거래종류 상세
    private BigDecimal transNum;    // 거래수량
    private String transUnit;    // 수량단위명
    private BigDecimal baseAmt;    // 거래단가
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal settleAmt;    // 정산금액
    private BigDecimal balanceAmt;    // 거래후잔액
    private String currencyCode;    // 통화코드
    private String transMemo;    // 적요
    private String exCode;    // 거래소 코드

    public InvtAccHistForm getForm(FormBase formBase, String accountNum){
        InvtAccHistForm form = new InvtAccHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setProdName(prodName);
        form.setProdCode(prodCode);
        form.setTransType(transType);
        form.setTransTypeDetail(transTypeDetail);
        form.setTransNum(transNum);
        form.setTransUnit(transUnit);
        form.setBaseAmt(baseAmt);
        form.setTransAmt(transAmt);
        form.setSettleAmt(settleAmt);
        form.setBalanceAmt(balanceAmt);
        form.setCurrencyCode(currencyCode);
        form.setTransMemo(transMemo);
        form.setExCode(exCode);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
