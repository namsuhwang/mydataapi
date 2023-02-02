package com.albee.mydataapi.api.base.itfn.models.form;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLeaseHistForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호
    private String transType;    // 거래유형
    private BigDecimal transAmt;    // 거래금액

    public ItfnLeaseHistEntity getEntity(){
        ItfnLeaseHistEntity entity = new ItfnLeaseHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setTransDtime(transDtime);
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
