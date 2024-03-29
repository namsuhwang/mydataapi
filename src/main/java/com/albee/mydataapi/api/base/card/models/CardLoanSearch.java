package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardLoanForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardLoanSearch extends SearchDto {
    private String isLoanShortTerm;    // 단기대출 (여부)
    private String isLoanLongTerm;    // 장기대출 (여부)

    public CardLoanSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardLoanSearch(String memberId, String orgCd, String isLoanShortTerm, String isLoanLongTerm) {
        super(memberId, orgCd);
        this.isLoanShortTerm = isLoanShortTerm;
        this.isLoanLongTerm = isLoanLongTerm;
    }

    public CardLoanSearch(CardLoanEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.isLoanShortTerm = entity.getIsLoanShortTerm();
        this.isLoanLongTerm = entity.getIsLoanLongTerm();
    }

    public CardLoanSearch(CardLoanForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.isLoanShortTerm = form.getIsLoanShortTerm();
        this.isLoanLongTerm = form.getIsLoanLongTerm();
    }
}
