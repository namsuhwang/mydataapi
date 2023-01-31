package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardForm extends FormBase {
    private String cardId;    // 카드 식별자
    private String cardNum;    // 카드번호
    private String isConsent;    // 전송요구 여부
    private String cardName;    // 카드상품명
    private String cardMember;    // 본인/가족구분(코드)
    private String cardType;    // 카드 구분 (코드)

    public CardEntity getEntity(){
        CardEntity entity = new CardEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setCardId(cardId);
        entity.setCardNum(cardNum);
        entity.setIsConsent(isConsent);
        entity.setCardName(cardName);
        entity.setCardMember(cardMember);
        entity.setCardType(cardType);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
