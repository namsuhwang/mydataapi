package com.kpcnc.mydataapi.api.base.bond.models.form;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transAmt;    // 거래금액
    private Long balanceAmt;    // 거래 후 대출잔액
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal principalAmt;    // 거래금액 중 원금
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자

    private String chgDt;    // 수정일시

    public BondHistEntity getEntity(){
        BondHistEntity entity = new BondHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setBondNum(bondNum);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setIntAmt(intAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(regDt);
        return entity;
    }
}
