package com.albee.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanForm;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Insu008ResDetailDto {

    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private Boolean isConsent;    // 전송요구 여부
    private String accountType;    // 계좌번호 별 구분 코드
    private String accountStatus;    // 계좌번호 별 상태 코드

    public InsuLoanForm getForm(FormBase formBase){
        InsuLoanForm form = new InsuLoanForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setProdName(prodName);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setAccountType(accountType);
        form.setAccountStatus(accountStatus);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
