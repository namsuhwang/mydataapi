package com.abcc.mydataapi.api.base.bank.models.form;

import com.abcc.mydataapi.api.base.bank.models.entity.BankAccEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankAccForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String isForeignDeposit;    // 외화계좌여부
    private String prodName;    // 상품명
    private String isMinus;    // 마이너스약정 여부
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)

    public BankAccEntity getEntity(){
        BankAccEntity entity = new BankAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setIsConsent(isConsent);
        entity.setSeqno(seqno);
        entity.setIsForeignDeposit(isForeignDeposit);
        entity.setProdName(prodName);
        entity.setIsMinus(isMinus);
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
