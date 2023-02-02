package com.albee.mydataapi.api.base.card.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayDetailEntity extends EntityBase {
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일
    private Long payAmt;    // 결제예정금액
    private String lumpSumAmt;    // 일시불
    private String monthlyAmt;    // 할부
    private String loanShortAmt;    // 단기대출(현 금서비스)
    private String revolvingAmt;    // 리볼빙
    private String loanLongAmt;    // 장기대출(카 드론)
    private String etcAmt;    // 연회비 및 기타
}
