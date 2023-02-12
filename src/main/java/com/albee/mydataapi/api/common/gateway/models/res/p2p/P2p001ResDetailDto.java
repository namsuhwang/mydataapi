package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class P2p001ResDetailDto {

    private String lendingId;    // 대출계약번호
    private Boolean isConsent;    // 전송요구 여부
    private String type;    // 상품유형 (코드)
    private BigDecimal lendingAmt;    // 대출계약금액
    private String issueDate;    // 대출일

    public P2pLoanForm getForm(FormBase formBase){
        P2pLoanForm form = new P2pLoanForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLendingId(lendingId);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setType(type);
        form.setLendingAmt(lendingAmt);
        form.setIssueDate(issueDate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
