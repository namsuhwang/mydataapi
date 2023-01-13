package com.kpcnc.mydataapi.api.base.elec.models.form;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecAccForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String subKey;    // Sub key
    private String accountId;    // 계정식별값
    private String isConsent;    // 전송요구여부
    private String regDate;    // 가입일
    private String isPay;    // 결제수단 등록 여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ElecAccEntity getEntity(){
        ElecAccEntity entity = new ElecAccEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setSubKey(subKey);
        entity.setAccountId(accountId);
        entity.setIsConsent(isConsent);
        entity.setRegDate(regDate);
        entity.setIsPay(isPay);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
