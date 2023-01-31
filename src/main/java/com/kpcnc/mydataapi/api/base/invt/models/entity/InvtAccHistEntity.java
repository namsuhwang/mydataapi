package com.kpcnc.mydataapi.api.base.invt.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccHistEntity extends EntityBase {
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
}
