package com.abcc.mydataapi.api.common.gateway.models.res.dc;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.base.dc.models.form.DcHistForm;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Dc003ResDetailDto {

    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래구분. 01 : 입금, 02 : 지급
    private BigDecimal transAmt;    //  거래금액

    public DcHistForm getForm(FormBase formBase, String dcNum){
        DcHistForm form = new DcHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setDcNum(dcNum);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransType(transType);
        form.setTransAmt(transAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
