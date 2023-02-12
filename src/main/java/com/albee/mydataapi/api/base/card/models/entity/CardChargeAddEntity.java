package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardChargeAddEntity extends EntityBase {
    private String seqno;    // 결제순번
    private String chargeMonth;    // 청구년월
    private String cardId;    // 카드 식별자
    private String paidDtime;    // 사용일시 또는 사용일자
    private String transNo;    // 거래번호
    private BigDecimal paidAmt;    // 이용금액
    private String currencyCode;    // 통화코드 (이용금액)
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번호
    private Long creditFeeAmt;    // 신용판매 수수료
    private Integer totalInstallCnt;    // 전체 할부회차
    private Integer curInstallCnt;    // 현재 할부회차
    private Long balanceAmt;    // 할부 결제 후 잔액
    private String prodType;    // 상품구분 (코드) 
}
