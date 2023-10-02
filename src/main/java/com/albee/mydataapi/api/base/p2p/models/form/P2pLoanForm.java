package com.albee.mydataapi.api.base.p2p.models.form;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanEntity;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class P2pLoanForm extends FormBase {
    private String lendingId;    // 대출계약번호
    private String isConsent;    // 전송요구 여부
    private String type;    // 상품유형 (코드)
    private BigDecimal lendingAmt;    // 대출계약금액
    private String issueDate;    // 대출일

    public P2pLoanEntity getEntity(){
        P2pLoanEntity entity = new P2pLoanEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setLendingId(lendingId);
        entity.setIsConsent(isConsent);
        entity.setType(type);
        entity.setLendingAmt(lendingAmt);
        entity.setIssueDate(issueDate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
