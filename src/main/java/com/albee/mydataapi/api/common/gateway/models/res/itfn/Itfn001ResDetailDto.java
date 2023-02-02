package com.albee.mydataapi.api.common.gateway.models.res.itfn;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Itfn001ResDetailDto {

    private String accountNum;    // 계좌번호
    private Boolean isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String prodName;    // 상품명
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)

    public ItfnAccForm getForm(FormBase formBase){
        ItfnAccForm form = new ItfnAccForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setAccountNum(accountNum);
        form.setIsConsent(isConsent ? "Y" : "N");
        form.setSeqno(seqno);
        form.setProdName(prodName);
        form.setAccountType(accountType);
        form.setAccountStatus(accountStatus);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
