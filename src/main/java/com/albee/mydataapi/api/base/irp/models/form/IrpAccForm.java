package com.albee.mydataapi.api.base.irp.models.form;

import com.albee.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class IrpAccForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부

    public IrpAccForm(String memberId, String orgCd, String accountNum) {
        super(memberId, orgCd);
        this.accountNum = accountNum;
    }

    public IrpAccEntity getEntity(){
        IrpAccEntity entity = new IrpAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setProdName(prodName);
        entity.setIsConsent(isConsent);
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
