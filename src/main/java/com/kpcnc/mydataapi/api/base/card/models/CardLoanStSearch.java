package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanStEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanStForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
