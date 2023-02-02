package com.albee.mydataapi.api.base.elec.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayHistEntity extends EntityBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형(코드)
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private String transOrgCode;    // 거래상대 기관(코드)
    private String transId;    // 거래상대 식별값
    private String transNum;    // 주문번호
    private String transMemo;    // 거래메모
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점사업자 등록번호
    private String transTitle;    // 상품(구매)제 목
    private String transCategory;    // 상품(구매)분 류 (코드)
    private String payMethod;    // 결제방법 (코드)
    private String isScheduled;    // 정기결제여부
}
