package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanBaseForm;
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
public class P2p002ResDto extends ResBaseDto {

    private String expDate;    // 만기일
    private Float offeredRate;    // 대출금리
    private String repayMethod;    // 상환방식 (코드)
    private Float ltvRate;    // 부동산담보 LTV 비율

    public P2pLoanBaseForm getForm(FormBase formBase, String lendingId){
        P2pLoanBaseForm form = new P2pLoanBaseForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setLendingId(lendingId);
        form.setExpDate(expDate);
        form.setOfferedRate(offeredRate);
        form.setRepayMethod(repayMethod);
        form.setLtvRate(ltvRate);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }
}
