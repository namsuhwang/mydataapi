package com.abcc.mydataapi.api.base.p2p.models.form;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanBaseForm extends FormBase {
    private String lendingId;    // 대출계약번호
    private String expDate;    // 만기일
    private Float offeredRate;    // 대출금리
    private String repayMethod;    // 상환방식 (코드)
    private Float ltvRate;    // 부동산담보 LTV 비율

    public P2pLoanBaseEntity getEntity(){
        P2pLoanBaseEntity entity = new P2pLoanBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLendingId(lendingId);
        entity.setExpDate(expDate);
        entity.setOfferedRate(offeredRate);
        entity.setRepayMethod(repayMethod);
        entity.setLtvRate(ltvRate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
