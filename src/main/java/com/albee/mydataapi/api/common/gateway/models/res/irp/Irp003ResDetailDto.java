package com.albee.mydataapi.api.common.gateway.models.res.irp;

import com.albee.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Irp003ResDetailDto {

    private String irpName;    // 상품명
    private String irpNo;    // 계좌번호
    private String irpType;    // 상품유형(코드). 01 : 원리금 보장, 02 : 원리금 비보장, 03 : 기타
    private BigDecimal evalAmt;    //  평가금액
    private BigDecimal invPrincipal;    //  납입(투자)원금
    private BigDecimal fundNum;    //  보유좌수
    private String openDate;    //  신규일
    private String expDate;    //  만기일
    private Float intRate;    // 약정이자율

    public IrpAccAddForm getForm(FormBase formBase, String accountNum){
        IrpAccAddForm form = new IrpAccAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setIrpName(irpName);
        form.setIrpType(irpType);
        form.setEvalAmt(evalAmt);
        form.setInvPrincipal(invPrincipal);
        form.setFundNum(fundNum);
        form.setOpenDate(openDate);
        form.setExpDate(expDate);
        form.setIntRate(intRate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
