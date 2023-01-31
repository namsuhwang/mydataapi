package com.kpcnc.mydataapi.api.base.card.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardOsPcaEntity extends EntityBase {
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호
    private String purchaseDate;    // 매입일자
    private String salesDate;    // 매출일자
    private String priApprovedNum;    // 원승인번호
    private String priApprovedDtime;    // 원승인일시
    private BigDecimal priApprovedAmt;    // 원승인금액
    private Long priKrwAmt;    // 원승인금액 원화
    private String priCurrencyCode;    // 원승인금액 통화코드
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String merchantName;    // 가맹점명
    private BigDecimal approvedAmt;    // 이용금액
    private String countryCode;    // 결제(매입) 국가코드
    private String currencyCode;    // 결제(매입) 시 통화코드
    private Long krwAmt;    // 원화
}
