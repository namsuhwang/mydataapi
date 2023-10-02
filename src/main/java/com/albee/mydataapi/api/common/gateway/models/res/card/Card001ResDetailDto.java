package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardForm;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Card001ResDetailDto {

    private String cardId;    // 카드 식별자
    private String cardNum;    // 카드번호
    private Boolean isConsent;    // 전송요구 여부
    private String cardName;    // 카드상품명
    private String cardMember;    // 본인/가족구분(코드)
    private String cardType;    // 카드 구분 (코드)

    public CardForm getForm(FormBase formBase){
        CardForm form = new CardForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setCardId(cardId);
        form.setCardNum(cardNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setCardName(cardName);
        form.setCardMember(cardMember);
        form.setCardType(cardType);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
