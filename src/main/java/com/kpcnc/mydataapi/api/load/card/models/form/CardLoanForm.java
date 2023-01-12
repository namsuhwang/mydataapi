package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardLoanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardLoanForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String isLoanShortTerm;    // 단기대출 (여부)
    private String isLoanLongTerm;    // 장기대출 (여부)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardLoanEntity getEntity(){
        CardLoanEntity entity = new CardLoanEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setIsLoanShortTerm(isLoanShortTerm);
        entity.setIsLoanLongTerm(isLoanLongTerm);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
