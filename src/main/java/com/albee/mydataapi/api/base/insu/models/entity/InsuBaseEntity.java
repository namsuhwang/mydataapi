package com.albee.mydataapi.api.base.insu.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuBaseEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String isRenewable;    // 갱신여부 (여부)
    private String issueDate;    // 계약체결일
    private String expDate;    // 만기일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String currencyCode;    // 통화코드(보 험가입금액)
    private String isVariable;    // 변액보험 여부
    private String isUniversal;    // 유니버셜 여부
    private String pensionRcvStartDate;    // 연금개시일
    private String pensionRcvCycle;    // 연금수령주기
    private String isLoanable;    // 대출실행 가능 상품 여부
    private Integer insuredCnt;    // 피보험자수
}
