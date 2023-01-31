package com.kpcnc.mydataapi.api.base.bond.models.form;

import com.kpcnc.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondHistForm extends FormBase {
    private String bondNum;    // 채권번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private Long transAmt;    // 거래금액
    private Long balanceAmt;    // 거래 후 대출잔액
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal principalAmt;    // 거래금액 중 원금

    public BondHistEntity getEntity(){
        BondHistEntity entity = new BondHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setBondNum(bondNum);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setIntAmt(intAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
