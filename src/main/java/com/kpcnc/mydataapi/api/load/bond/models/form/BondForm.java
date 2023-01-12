package com.kpcnc.mydataapi.api.load.bond.models.form;

import com.kpcnc.mydataapi.api.load.bond.models.entity.BondEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호
    private String isConsent;    // 전송요구여부
    private String bondType;    // 기관분류 (코드)
    private String takeoverDate;    // 채권인수일/ 특수채권편입 일/최초대출 일
    private String initOrgCode;    // 최초 대출기관
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public BondEntity getEntity(){
        BondEntity entity = new BondEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setBondNum(bondNum);
        entity.setIsConsent(isConsent);
        entity.setBondType(bondType);
        entity.setTakeoverDate(takeoverDate);
        entity.setInitOrgCode(initOrgCode);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
