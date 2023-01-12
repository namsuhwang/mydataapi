package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayDetailForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String seqno;    // 결제순번
    private String payDueDate;    // 결제예정일
    private Long payAmt;    // 결제예정금액
    private String lumpSumAmt;    // 일시불
    private String monthlyAmt;    // 할부
    private String loanShortAmt;    // 단기대출(현 금서비스)
    private String revolvingAmt;    // 리볼빙
    private String loanLongAmt;    // 장기대출(카 드론)
    private String etcAmt;    // 연회비 및 기타
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardPayDetailEntity getEntity(){
        CardPayDetailEntity entity = new CardPayDetailEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setSeqno(seqno);
        entity.setPayDueDate(payDueDate);
        entity.setPayAmt(payAmt);
        entity.setLumpSumAmt(lumpSumAmt);
        entity.setMonthlyAmt(monthlyAmt);
        entity.setLoanShortAmt(loanShortAmt);
        entity.setRevolvingAmt(revolvingAmt);
        entity.setLoanLongAmt(loanLongAmt);
        entity.setEtcAmt(etcAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
