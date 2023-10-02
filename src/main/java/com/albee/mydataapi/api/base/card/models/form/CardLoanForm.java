package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanForm extends FormBase {
    private String isLoanShortTerm;    // 단기대출 (여부)
    private String isLoanLongTerm;    // 장기대출 (여부)

    public CardLoanEntity getEntity(){
        CardLoanEntity entity = new CardLoanEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setIsLoanShortTerm(isLoanShortTerm);
        entity.setIsLoanLongTerm(isLoanLongTerm);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
