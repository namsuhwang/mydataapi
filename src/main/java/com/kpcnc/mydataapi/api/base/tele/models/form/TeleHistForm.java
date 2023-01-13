package com.kpcnc.mydataapi.api.base.tele.models.form;

import com.kpcnc.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호
    private String transMonth;    // 납부연월
    private BigDecimal paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public TeleHistEntity getEntity(){
        TeleHistEntity entity = new TeleHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setMgmtId(mgmtId);
        entity.setTransMonth(transMonth);
        entity.setPaidAmt(paidAmt);
        entity.setPayMethod(payMethod);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
