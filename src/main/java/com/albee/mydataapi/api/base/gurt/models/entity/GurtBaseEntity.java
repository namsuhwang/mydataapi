package com.albee.mydataapi.api.base.gurt.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtBaseEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String issueDate;    // 계약체결일
    private String expDate;    // 종료일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String payDue;    // 납입기간구분(코드)
    private BigDecimal payAmt;    // 총 납입 보험료
    private Integer insuredCnt;    // 피보험자수
}
