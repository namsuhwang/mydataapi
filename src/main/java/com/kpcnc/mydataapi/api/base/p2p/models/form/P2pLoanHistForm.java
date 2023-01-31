package com.kpcnc.mydataapi.api.base.p2p.models.form;

import com.kpcnc.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanHistForm extends FormBase {
    private String lendingId;    // 대출계약번호
    private Long transDtime;    // 상환일시
    private Integer repayCnt;    // 상환 회차
    private String repayType;    // 상환유형 (코드)
    private Long transAmt;    // 상환금액
    private Long principalAmt;    // 상환금액 중 원금
    private Long intAmt;    // 상환금액 중 이자

    public P2pLoanHistEntity getEntity(){
        P2pLoanHistEntity entity = new P2pLoanHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLendingId(lendingId);
        entity.setTransDtime(transDtime);
        entity.setRepayCnt(repayCnt);
        entity.setRepayType(repayType);
        entity.setTransAmt(transAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setIntAmt(intAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
