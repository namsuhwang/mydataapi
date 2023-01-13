package com.kpcnc.mydataapi.api.base.elec.models.form;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String fobName;    // 권면명
    private String isConsent;    // 전송요구 여부
    private String regDate;    // 가입일자
    private Integer limitAmt;    // 권면한도
    private String isCharge;    // 자동충전 등록 여부
    private String isWithdrawable;    // 출금 가능 여부
    private Integer currencyCode;    // 통화코드
    private Integer accountCnt;    // 계정수
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ElecPpayEntity getEntity(){
        ElecPpayEntity entity = new ElecPpayEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setFobId(fobId);
        entity.setFobName(fobName);
        entity.setIsConsent(isConsent);
        entity.setRegDate(regDate);
        entity.setLimitAmt(limitAmt);
        entity.setIsCharge(isCharge);
        entity.setIsWithdrawable(isWithdrawable);
        entity.setCurrencyCode(currencyCode);
        entity.setAccountCnt(accountCnt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
