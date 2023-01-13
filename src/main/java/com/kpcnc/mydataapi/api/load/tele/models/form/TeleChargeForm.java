package com.kpcnc.mydataapi.api.load.tele.models.form;

import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleChargeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleChargeForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호
    private String chargeMonth;    // 청구년월
    private BigDecimal chargeAmt;    // 청구금액
    private String chargeDate;    // 납부예정일자
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public TeleChargeEntity getEntity(){
        TeleChargeEntity entity = new TeleChargeEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setMgmtId(mgmtId);
        entity.setChargeMonth(chargeMonth);
        entity.setChargeAmt(chargeAmt);
        entity.setChargeDate(chargeDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
