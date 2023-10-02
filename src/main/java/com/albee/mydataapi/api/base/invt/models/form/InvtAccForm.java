package com.albee.mydataapi.api.base.invt.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String accountName;    // 계좌명
    private String accountType;    // 계좌종류(코드)
    private String issueDate;    // 계좌개설일
    private String isTaxBenefits;    // 세제혜택 적용여부(계좌)
    private String isCma;    // CMA상품포함 여부
    private String isStockTrans;    // 주식거래가능 여부
    private String isAccountLink;    // 은행예수금 방식계좌여부

    public InvtAccEntity getEntity(){
        InvtAccEntity entity = new InvtAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setIsConsent(isConsent);
        entity.setAccountName(accountName);
        entity.setAccountType(accountType);
        entity.setIssueDate(issueDate);
        entity.setIsTaxBenefits(isTaxBenefits);
        entity.setIsCma(isCma);
        entity.setIsStockTrans(isStockTrans);
        entity.setIsAccountLink(isAccountLink);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
