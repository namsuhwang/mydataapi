package com.kpcnc.mydataapi.api.load.invt.models.form;

import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
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
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InvtAccHistEntity getEntity(){
        InvtAccHistEntity entity = new InvtAccHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
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
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
