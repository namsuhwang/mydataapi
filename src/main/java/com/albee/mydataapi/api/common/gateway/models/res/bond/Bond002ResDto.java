package com.albee.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.bond.models.form.BondBalForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Bond002ResDto extends ResBaseDto {

    private String prevOrgCode;    // 직전 채권인계기관
    private Boolean isDebtMgmt;    // 채무조정 여부
    private String repayMethod;    // 상환방식 (코드)
    private Long balanceAmt;    // 대출잔액
    private Long bondPrincipal;    // 대출원금

    public BondBalForm getForm(FormBase formBase, String bondNum){
        BondBalForm form = new BondBalForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setBondNum(bondNum);
        form.setPrevOrgCode(prevOrgCode);
        form.setIsDebtMgmt(isDebtMgmt ? "Y" : "N");
        form.setRepayMethod(repayMethod);
        form.setBalanceAmt(balanceAmt);
        form.setBondPrincipal(bondPrincipal);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
