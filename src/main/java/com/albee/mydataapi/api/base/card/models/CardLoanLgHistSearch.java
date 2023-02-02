package com.albee.mydataapi.api.base.card.models;

import com.albee.mydataapi.api.base.card.models.form.CardLoanLgHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.card.models.entity.CardLoanLgHistEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class CardLoanLgHistSearch extends SearchDto {
    private String loanNum;    // 대출번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호

    public CardLoanLgHistSearch(String memberId, String orgCd, String loanNum) {
        super(memberId, orgCd);
        this.loanNum = loanNum;
    }

    public CardLoanLgHistSearch(String memberId, String orgCd, String loanNum, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.loanNum = loanNum;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public CardLoanLgHistSearch(CardLoanLgHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.loanNum = entity.getLoanNum();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public CardLoanLgHistSearch(CardLoanLgHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.loanNum = form.getLoanNum();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
