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
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanDtime;    // 이용일시

    public CardLoanStSearch(String memberId, String orgCd, String loanDtime) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.loanDtime = loanDtime;
    }

    public CardLoanStSearch(CardLoanStEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.loanDtime = entity.getLoanDtime();
    }

    public CardLoanStSearch(CardLoanStForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.loanDtime = form.getLoanDtime();
    }
}
