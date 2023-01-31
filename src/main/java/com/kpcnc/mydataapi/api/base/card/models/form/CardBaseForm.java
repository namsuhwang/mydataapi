package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardBaseEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardBaseForm extends FormBase {
    private String cardId;    // 카드 식별자
    private String isTransPayable;    // 교통기능(여부)
    private String isCashCard;    // 현금카드기능 (여부)
    private String linkedBankCode;    // 결제은행 (코드)
    private String accountNum;    // 결제계좌번호
    private String cardBrand;    // 카드브랜드 (코드)
    private Long annualFee;    // 상품 연회비
    private String issueDate;    // 발급일자

    public CardBaseEntity getEntity(){
        CardBaseEntity entity = new CardBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setCardId(cardId);
        entity.setIsTransPayable(isTransPayable);
        entity.setIsCashCard(isCashCard);
        entity.setLinkedBankCode(linkedBankCode);
        entity.setAccountNum(accountNum);
        entity.setCardBrand(cardBrand);
        entity.setAnnualFee(annualFee);
        entity.setIssueDate(issueDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
