package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardRvForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일
    private String closeDate;    // 리볼빙 해지일자
    private Float minPayRate;    // 최소결제비율
    private Long minPayAmt;    // 최소결제금액
    private Float agreedPayRate;    // 약정결제비율
    private Long agreedPayAmt;    // 약정결제금액
    private Long remainedAmt;    // 리볼빙 이월잔액
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardRvEntity getEntity(){
        CardRvEntity entity = new CardRvEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setReqDate(reqDate);
        entity.setEndDate(endDate);
        entity.setCloseDate(closeDate);
        entity.setMinPayRate(minPayRate);
        entity.setMinPayAmt(minPayAmt);
        entity.setAgreedPayRate(agreedPayRate);
        entity.setAgreedPayAmt(agreedPayAmt);
        entity.setRemainedAmt(remainedAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
