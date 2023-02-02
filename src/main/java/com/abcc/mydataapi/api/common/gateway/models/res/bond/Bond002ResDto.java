package com.abcc.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
