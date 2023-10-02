package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardLoanStSearch extends SearchDto {
    private String loanDtime;    // 이용일시

    public CardLoanStSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardLoanStSearch(String memberId, String orgCd, String loanDtime) {
        super(memberId, orgCd);
        this.loanDtime = loanDtime;
    }

    public CardLoanStSearch(CardLoanStEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.loanDtime = entity.getLoanDtime();
    }

    public CardLoanStSearch(CardLoanStForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.loanDtime = form.getLoanDtime();
    }
}
