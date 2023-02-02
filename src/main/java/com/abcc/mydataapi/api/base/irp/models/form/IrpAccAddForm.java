package com.abcc.mydataapi.api.base.irp.models.form;

import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IrpAccAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String irpName;    // 개별운용상품명
    private String irpNo;    // 상품가입번호
    private String irpType;    // 상품유형 (코드)
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal invPrincipal;    // 납입(투자)원 금
    private BigDecimal fundNum;    // 보유좌수
    private String openDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율

    public IrpAccAddEntity getEntity(){
        IrpAccAddEntity entity = new IrpAccAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setIrpName(irpName);
        entity.setIrpNo(irpNo);
        entity.setIrpType(irpType);
        entity.setEvalAmt(evalAmt);
        entity.setInvPrincipal(invPrincipal);
        entity.setFundNum(fundNum);
        entity.setOpenDate(openDate);
        entity.setExpDate(expDate);
        entity.setIntRate(intRate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
