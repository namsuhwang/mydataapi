package com.kpcnc.mydataapi.api.base.insu.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdMiBaseEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String isRenewable;    // 갱신여부 (여부)
    private Integer issueDate;    // 계약체결일
    private Integer expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private String contractorName;    // 계약자명
    private Integer prizeCnt;    // 목적물수
}
