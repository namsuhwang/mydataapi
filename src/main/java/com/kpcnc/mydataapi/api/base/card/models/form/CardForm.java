package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자
    private String cardNum;    // 카드번호
    private String isConsent;    // 전송요구 여부
    private String cardName;    // 카드상품명
    private String cardMember;    // 본인/가족구분(코드)
    private String cardType;    // 카드 구분 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardEntity getEntity(){
        CardEntity entity = new CardEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setCardId(cardId);
        entity.setCardNum(cardNum);
        entity.setIsConsent(isConsent);
        entity.setCardName(cardName);
        entity.setCardMember(cardMember);
        entity.setCardType(cardType);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
