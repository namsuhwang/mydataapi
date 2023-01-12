package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardPayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardPayForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String isRevolving;    // 리볼빙 (여부)
    private Integer payCnt;    // 결제기본정보 목록수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardPayEntity getEntity(){
        CardPayEntity entity = new CardPayEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setIsRevolving(isRevolving);
        entity.setPayCnt(payCnt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
