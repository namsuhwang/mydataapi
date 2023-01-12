package com.kpcnc.mydataapi.api.load.card.models;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanEntity;
import com.kpcnc.mydataapi.api.load.card.models.form.CardLoanForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardLoanSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String isLoanShortTerm;    // 단기대출 (여부)
    private String isLoanLongTerm;    // 장기대출 (여부)

    public CardLoanSearch(String memberId, String orgCd, String isLoanShortTerm, String isLoanLongTerm) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.isLoanShortTerm = isLoanShortTerm;
        this.isLoanLongTerm = isLoanLongTerm;
    }

    public CardLoanSearch(CardLoanEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.isLoanShortTerm = entity.getIsLoanShortTerm();
        this.isLoanLongTerm = entity.getIsLoanLongTerm();
    }

    public CardLoanSearch(CardLoanForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.isLoanShortTerm = form.getIsLoanShortTerm();
        this.isLoanLongTerm = form.getIsLoanLongTerm();
    }
}
