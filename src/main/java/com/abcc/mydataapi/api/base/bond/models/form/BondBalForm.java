package com.abcc.mydataapi.api.base.bond.models.form;

import com.abcc.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BondBalForm extends FormBase {
    private String bondNum;    // 채권번호
    private String prevOrgCode;    // 직전 채권인계기관
    private String isDebtMgmt;    // 채무조정 여부
    private String repayMethod;    // 상환방식 (코드)
    private Long balanceAmt;    // 대출잔액
    private Long bondPrincipal;    // 대출원금

    public BondBalEntity getEntity(){
        BondBalEntity entity = new BondBalEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setBondNum(bondNum);
        entity.setPrevOrgCode(prevOrgCode);
        entity.setIsDebtMgmt(isDebtMgmt);
        entity.setRepayMethod(repayMethod);
        entity.setBalanceAmt(balanceAmt);
        entity.setBondPrincipal(bondPrincipal);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
