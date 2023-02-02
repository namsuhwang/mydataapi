package com.albee.mydataapi.api.base.irp.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccHistEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래구분
    private String transNo;    // 거래번호
    private BigDecimal transAmt;    // 거래금액
}
