package com.albee.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.albee.mydataapi.common.models.form.FormBase;
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
public class Ppay003ResDetailDto {

    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래유형 (코드)
    private String transNo;    // 거래번호
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private String transOrgCode;    // 거래상대 기관(코드)
    private String transId;    // 거래상대 식별값

    public PpayHistForm getForm(FormBase formBase, String ppId){
        PpayHistForm form = new PpayHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setPpId(ppId);
        form.setTransDtime(transDtime);
        form.setTransType(transType);
        form.setTransNo(transNo);
        form.setTransAmt(transAmt);
        form.setBalanceAmt(balanceAmt);
        form.setTransOrgCode(transOrgCode);
        form.setTransId(transId);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
