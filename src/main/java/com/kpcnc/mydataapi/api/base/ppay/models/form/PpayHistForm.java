package com.kpcnc.mydataapi.api.base.ppay.models.form;

import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PpayHistForm extends FormBase {
    private String ppId;    // 선불카드 식별자
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래유형 (코드)
    private String transNo;    // 거래번호
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private String transOrgCode;    // 거래상대 기관(코드)
    private String transId;    // 거래상대 식별값

    public PpayHistEntity getEntity(){
        PpayHistEntity entity = new PpayHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setPpId(ppId);
        entity.setTransDtime(transDtime);
        entity.setTransType(transType);
        entity.setTransNo(transNo);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setTransOrgCode(transOrgCode);
        entity.setTransId(transId);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
