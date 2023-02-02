package com.albee.mydataapi.api.base.irp.models.form;

import com.albee.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래구분
    private String transNo;    // 거래번호
    private BigDecimal transAmt;    // 거래금액

    public IrpAccHistEntity getEntity(){
        IrpAccHistEntity entity = new IrpAccHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setTransDtime(transDtime);
        entity.setTransType(transType);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransAmt(transAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
