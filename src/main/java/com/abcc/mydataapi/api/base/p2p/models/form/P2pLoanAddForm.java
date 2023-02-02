package com.abcc.mydataapi.api.base.p2p.models.form;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanAddForm extends FormBase {
    private String lendingId;    // 대출계약번호
    private Long balanceAmt;    // 대출잔액
    private Integer nextRepayCnt;    // 다음 상환 회차
    private String nextRepayDate;    // 다음 상환일
    private Long principalAmt;    // 예정원금
    private Long intAmt;    // 예정이자

    public P2pLoanAddEntity getEntity(){
        P2pLoanAddEntity entity = new P2pLoanAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLendingId(lendingId);
        entity.setBalanceAmt(balanceAmt);
        entity.setNextRepayCnt(nextRepayCnt);
        entity.setNextRepayDate(nextRepayDate);
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
