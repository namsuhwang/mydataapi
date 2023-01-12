package com.kpcnc.mydataapi.api.load.card.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardChargeEntity{
    private Long rowNum;
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번
    private Long chargeAmt;    // 월별 청구금액
    private String chargeDay;    // 결제일
    private String chargeMonth;    // 청구년월
    private String paidOutDate;    // 결제년월일
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
