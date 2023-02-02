package com.abcc.mydataapi.api.base.ppay.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayHistEntity extends EntityBase {
    private String ppId;    // 선불카드 식별자
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래유형 (코드)
    private String transNo;    // 거래번호
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private String transOrgCode;    // 거래상대 기관(코드)
    private String transId;    // 거래상대 식별값
}
