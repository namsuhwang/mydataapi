package com.kpcnc.mydataapi.api.base.irp.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

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
