package com.abcc.mydataapi.api.common.gateway.models.res.invt;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Invt001ResDetailDto {

    private String accountNum;    // 계좌번호
    private Boolean isConsent;    // 전송요구 여부
    private String accountName;    // 계좌명
    private String accountType;    // 계좌종류(코드)
    private String issueDate;    // 계좌개설일
    private Boolean isTaxBenefits;    // 세제혜택 적용여부(계좌)
    private Boolean isCma;    // CMA상품포함 여부
    private Boolean isStockTrans;    // 주식거래가능 여부
    private Boolean isAccountLink;    // 은행예수금 방식계좌여부

    public InvtAccForm getForm(FormBase formBase){
        InvtAccForm form = new InvtAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setAccountName(accountName);
        form.setAccountType(accountType);
        form.setIssueDate(issueDate);
        form.setIsTaxBenefits(isTaxBenefits ? "Y" : "N");
        form.setIsCma(isCma ? "Y" : "N");
        form.setIsStockTrans(isStockTrans ? "Y" : "N");
        form.setIsAccountLink(isAccountLink ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
