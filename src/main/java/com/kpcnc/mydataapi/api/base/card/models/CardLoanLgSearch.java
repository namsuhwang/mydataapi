package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanLgEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanLgForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardLoanLgSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanNum;    // 대출번호
    private String loanDtime;    // 대출일시 또는 대출일자
    private Integer loanCnt;    // 일자의 대출회차

    public CardLoanLgSearch(String memberId, String orgCd, String loanNum, String loanDtime, Integer loanCnt) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.loanNum = loanNum;
        this.loanDtime = loanDtime;
        this.loanCnt = loanCnt;
    }

    public CardLoanLgSearch(CardLoanLgEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.loanNum = entity.getLoanNum();
        this.loanDtime = entity.getLoanDtime();
        this.loanCnt = entity.getLoanCnt();
    }

    public CardLoanLgSearch(CardLoanLgForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.loanNum = form.getLoanNum();
        this.loanDtime = form.getLoanDtime();
        this.loanCnt = form.getLoanCnt();
    }
}
