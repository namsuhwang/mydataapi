package com.albee.mydataapi.api.common.gateway.models.res.tele;

import com.albee.mydataapi.api.base.tele.models.form.TelePayForm;
import com.albee.mydataapi.common.models.form.FormBase;
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
public class Tele004ResDetailDto {

    private String transDate;    // 이용일시
    private Long transAmt;    // 결제금액
    private String orgRegno;    // 가맹점 사업자번호
    private String merchantName;    // 가맹점명
    private String transTitle;    // 결제상품명

    public TelePayForm getForm(FormBase formBase, String mgmtId){
        TelePayForm form = new TelePayForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setMgmtId(mgmtId);
        form.setTransDate(transDate);
        form.setTransAmt(transAmt);
        form.setOrgRegno(orgRegno);
        form.setMerchantName(merchantName);
        form.setTransTitle(transTitle);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
