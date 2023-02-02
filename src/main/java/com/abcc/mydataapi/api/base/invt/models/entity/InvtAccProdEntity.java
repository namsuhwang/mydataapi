package com.abcc.mydataapi.api.base.invt.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccProdEntity extends EntityBase {
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
}
