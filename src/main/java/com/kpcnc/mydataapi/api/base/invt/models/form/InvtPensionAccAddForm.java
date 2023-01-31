package com.kpcnc.mydataapi.api.base.invt.models.form;

import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtPensionAccAddForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String prodType;    // 연금가입일
    private BigDecimal prodTypeDetail;    // 납부총액
    private BigDecimal prodCode;    // 기출금액
    private String exCode;    // 최종납입일
    private BigDecimal prodName;    // 연금기수령액
    private String posType;    // 연금개시(예정)일
    private BigDecimal creditType;    // 금년납입금
    private String isTaxBenefits;    // 통화코드

    public InvtPensionAccAddEntity getEntity(){
        InvtPensionAccAddEntity entity = new InvtPensionAccAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setProdType(prodType);
        entity.setProdTypeDetail(prodTypeDetail);
        entity.setProdCode(prodCode);
        entity.setExCode(exCode);
        entity.setProdName(prodName);
        entity.setPosType(posType);
        entity.setCreditType(creditType);
        entity.setIsTaxBenefits(isTaxBenefits);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
