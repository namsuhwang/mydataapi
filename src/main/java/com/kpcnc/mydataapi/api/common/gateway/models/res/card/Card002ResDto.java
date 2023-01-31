package com.kpcnc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.api.base.card.models.form.CardBaseForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card002ResDto extends ResBaseDto {

    private Boolean isTransPayable;    // 교통기능(여부)
    private Boolean isCashCard;    // 현금카드기능 (여부)
    private String linkedBankCode;    // 결제은행 (코드)
    private String accountNum;    // 결제계좌번호
    private String cardBrand;    // 카드브랜드 (코드)
    private Long annualFee;    // 상품 연회비
    private String issueDate;    // 발급일자

    public CardBaseForm getForm(FormBase formBase, String cardId){
        CardBaseForm form = new CardBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setCardId(cardId);
        form.setIsTransPayable(isTransPayable ? "Y" : "N");
        form.setIsCashCard(isCashCard ? "Y" : "N");
        form.setLinkedBankCode(linkedBankCode);
        form.setAccountNum(accountNum);
        form.setCardBrand(cardBrand);
        form.setAnnualFee(annualFee);
        form.setIssueDate(issueDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
