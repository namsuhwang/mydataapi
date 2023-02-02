package com.albee.mydataapi.api.base.insu.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuMiSccontEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String insuredNo;    // 피보험인/물 번호
    private String contractName;    // 특약명
    private String contractStatus;    // 특약의 상태 (코드)
    private String contractExpDate;    // 특약만기일자
    private BigDecimal contractFaceAmt;    // 특약가입금액
    private String currencyCode;    // 통화코드(특 약가입금액)
    private String isRequired;    // 특약의 유형 (여부)
}
