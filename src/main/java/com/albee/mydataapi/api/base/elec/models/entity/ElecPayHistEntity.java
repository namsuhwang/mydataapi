package com.albee.mydataapi.api.base.elec.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPayHistEntity extends EntityBase {
    private String subKey;    // Sub key
    private String transDtime;    // 결제일시 또는 결제취소일시
    private String transNo;    // 결제번호
    private String transNum;    // 주문번호
    private String transType;    // 결제유형 (코드)
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 결제금액
    private String transOrgCode;    // 결제수단 기관 (코드)
    private String payType;    // 결제수단 식별코드
    private String payId;    // 결제수단 식별키
    private String approvedNum;    // 카드승인번호
    private String cardName;    // 카드명
    private Integer totalInstallCnt;    // 할부개월
    private String transMemo;    // 거래메모
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번 호
    private String transTitle;    // 상품(구매)제 목
    private String transCategory;    // 상품(구매)분 류 (코드)
    private String payMethod;    // 결제방법 (코드)
}
