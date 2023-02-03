package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class P2p004ResDetailDto {

    private String transDtime;    // 상환일시
    private Integer repayCnt;    // 상환 회차
    private String repayType;    // 상환유형 (코드)
    private Long transAmt;    // 상환금액
    private Long principalAmt;    // 상환금액 중 원금
    private Long intAmt;    // 상환금액 중 이자

    public P2pLoanHistForm getForm(FormBase formBase, String lendingId){
        P2pLoanHistForm form = new P2pLoanHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLendingId(lendingId);
        form.setTransDtime(transDtime);
        form.setRepayCnt(repayCnt);
        form.setRepayType(repayType);
        form.setTransAmt(transAmt);
        form.setPrincipalAmt(principalAmt);
        form.setIntAmt(intAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
