package com.abcc.mydataapi.api.base.tele.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleHistEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String transMonth;    // 납부연월
    private BigDecimal paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)
}
