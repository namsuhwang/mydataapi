package com.kpcnc.mydataapi.api.base.card.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity extends EntityBase {
    private String cardId;    // 카드 식별자
    private String cardNum;    // 카드번호
    private String isConsent;    // 전송요구 여부
    private String cardName;    // 카드상품명
    private String cardMember;    // 본인/가족구분(코드)
    private String cardType;    // 카드 구분 (코드)
}
