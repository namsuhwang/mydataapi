package com.albee.mydataapi.api.base.invt.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccHistForm extends FormBase {
    private String accountNum;    // 계좌번호
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

    public InvtAccHistEntity getEntity(){
        InvtAccHistEntity entity = new InvtAccHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setTransDtime(transDtime);
        entity.setProdName(prodName);
        entity.setProdCode(prodCode);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransTypeDetail(transTypeDetail);
        entity.setTransNum(transNum);
        entity.setTransUnit(transUnit);
        entity.setBaseAmt(baseAmt);
        entity.setTransAmt(transAmt);
        entity.setSettleAmt(settleAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setTransMemo(transMemo);
        entity.setExCode(exCode);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
