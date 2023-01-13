package com.kpcnc.mydataapi.api.base.card.models;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardLoanLgHistEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardLoanLgHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CardLoanLgHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String loanNum;    // 대출번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호

    public CardLoanLgHistSearch(String memberId, String orgCd, String loanNum, String transDtime, String transNo) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.loanNum = loanNum;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public CardLoanLgHistSearch(CardLoanLgHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.loanNum = entity.getLoanNum();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public CardLoanLgHistSearch(CardLoanLgHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.loanNum = form.getLoanNum();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
