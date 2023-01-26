package com.kpcnc.mydataapi.api.base.dc.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcHistEntity extends EntityBase {
    private String dcNum;    // 상품관리번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래구분 (코드)
    private BigDecimal transAmt;    // 거래금액
}
