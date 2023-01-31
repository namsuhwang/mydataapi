package com.kpcnc.mydataapi.api.base.card.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardRvEntity extends EntityBase {
    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일
    private String closeDate;    // 리볼빙 해지일자
    private Float minPayRate;    // 최소결제비율
    private Long minPayAmt;    // 최소결제금액
    private Float agreedPayRate;    // 약정결제비율
    private Long agreedPayAmt;    // 약정결제금액
    private Long remainedAmt;    // 리볼빙 이월잔액
}
