package com.abcc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.card.models.form.CardLoanForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card010ResDto extends ResBaseDto {

    private Boolean isLoanShortTerm;    // 단기대출 (여부)
    private Boolean isLoanLongTerm;    // 장기대출 (여부)

    public CardLoanForm getForm(FormBase formBase){
        CardLoanForm form = new CardLoanForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setIsLoanShortTerm(isLoanShortTerm ? "Y" : "N");
        form.setIsLoanLongTerm(isLoanLongTerm ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
