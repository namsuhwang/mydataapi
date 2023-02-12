package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class P2p003ResDto extends ResBaseDto {

    private Long balanceAmt;    // 대출잔액
    private Integer nextRepayCnt;    // 다음 상환 회차
    private String nextRepayDate;    // 다음 상환일
    private Long principalAmt;    // 예정원금
    private Long intAmt;    // 예정이자

    public P2pLoanAddForm getForm(FormBase formBase, String lendingId){
        P2pLoanAddForm form = new P2pLoanAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLendingId(lendingId);
        form.setBalanceAmt(balanceAmt);
        form.setNextRepayCnt(nextRepayCnt);
        form.setNextRepayDate(nextRepayDate);
        form.setPrincipalAmt(principalAmt);
        form.setIntAmt(intAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
