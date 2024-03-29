package com.albee.mydataapi.api.base.irp.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccAddEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String irpName;    // 개별운용상품명
    private String irpNo;    // 상품가입번호
    private String irpType;    // 상품유형 (코드)
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 납입(투자)원 금
    private BigDecimal fundNum;    // 보유좌수
    private String openDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율
}
