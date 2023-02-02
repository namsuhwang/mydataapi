package com.albee.mydataapi.api.base.itfn.models.form;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnAccForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String prodName;    // 상품명
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)

    public ItfnAccEntity getEntity(){
        ItfnAccEntity entity = new ItfnAccEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setIsConsent(isConsent);
        entity.setSeqno(seqno);
        entity.setProdName(prodName);
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
