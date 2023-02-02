package com.abcc.mydataapi.api.base.card.models;

import com.abcc.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardLoanLgSearch extends SearchDto {
    private String loanNum;    // 대출번호
    private String loanDtime;    // 대출일시 또는 대출일자
    private Integer loanCnt;    // 일자의 대출회차

    public CardLoanLgSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public CardLoanLgSearch(String memberId, String orgCd, String loanNum, String loanDtime, Integer loanCnt) {
        super(memberId, orgCd);
        this.loanNum = loanNum;
        this.loanDtime = loanDtime;
        this.loanCnt = loanCnt;
    }

    public CardLoanLgSearch(CardLoanLgEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.loanNum = entity.getLoanNum();
        this.loanDtime = entity.getLoanDtime();
        this.loanCnt = entity.getLoanCnt();
    }

    public CardLoanLgSearch(CardLoanLgForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.loanNum = form.getLoanNum();
        this.loanDtime = form.getLoanDtime();
        this.loanCnt = form.getLoanCnt();
    }
}
