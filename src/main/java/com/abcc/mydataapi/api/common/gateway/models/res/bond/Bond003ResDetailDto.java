package com.abcc.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.bond.models.form.BondHistForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bond003ResDetailDto {

    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private Long transAmt;    // 거래금액
    private Long balanceAmt;    // 거래 후 대출잔액
    private BigDecimal intAmt;    // 거래금액 중 이자
    private BigDecimal principalAmt;    // 거래금액 중 원금

    public BondHistForm getForm(FormBase formBase, String bondNum){
        BondHistForm form = new BondHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setBondNum(bondNum);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setIntAmt(intAmt);
        form.setPrincipalAmt(principalAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
