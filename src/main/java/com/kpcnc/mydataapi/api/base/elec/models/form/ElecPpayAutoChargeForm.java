package com.kpcnc.mydataapi.api.base.elec.models.form;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayAutoChargeForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)
    private String chargeAccountNum;    // 충전지불수단 식별키
    private String chargeOption;    // 충전조건 (코드)
    private String chargeDay;    // 기준날짜
    private BigDecimal chargeBaseAmt;    // 기준금액
    private BigDecimal chargeAmt;    // 충전금액
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public ElecPpayAutoChargeEntity getEntity(){
        ElecPpayAutoChargeEntity entity = new ElecPpayAutoChargeEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setAutoChargeSeq(autoChargeSeq);
        entity.setChargeOrgCode(chargeOrgCode);
        entity.setChargeAccountNum(chargeAccountNum);
        entity.setChargeOption(chargeOption);
        entity.setChargeDay(chargeDay);
        entity.setChargeBaseAmt(chargeBaseAmt);
        entity.setChargeAmt(chargeAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
