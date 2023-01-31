package com.kpcnc.mydataapi.api.base.insu.models.form;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부
    private String accountType;    // 계좌번호 별 구분 코드
    private String accountStatus;    // 계좌번호 별 상태 코드

    public InsuLoanEntity getEntity(){
        InsuLoanEntity entity = new InsuLoanEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setProdName(prodName);
        entity.setIsConsent(isConsent);
        entity.setAccountType(accountType);
        entity.setAccountStatus(accountStatus);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
