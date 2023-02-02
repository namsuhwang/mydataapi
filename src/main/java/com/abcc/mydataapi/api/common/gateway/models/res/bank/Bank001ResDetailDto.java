package com.abcc.mydataapi.api.common.gateway.models.res.bank;

import com.abcc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank001ResDetailDto {

    private String accountNum;    // 계좌번호
    private Boolean isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String isForeignDeposit;    // 외화계좌여부
    private String prodName;    // 상품명
    private Boolean isMinus;    // 마이너스약정 여부
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)

    public BankAccForm getForm(FormBase formBase){
        BankAccForm form = new BankAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setSeqno(seqno);
        form.setIsForeignDeposit(isForeignDeposit);
        form.setProdName(prodName);
        form.setIsMinus(isMinus ? "Y" : "N");
        form.setAccountType(accountType);
        form.setAccountStatus(accountStatus);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
