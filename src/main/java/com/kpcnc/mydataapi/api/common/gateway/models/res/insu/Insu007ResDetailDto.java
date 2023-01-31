package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
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
public class Insu007ResDetailDto {

    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private Long faceAmt;    // 자동차보험 보험료
    private Integer paidInCnt;    // 납입회차
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)
    private String payOrgCode;    // 납입기관(코 드)
    private String payAccountNum;    // 납입 계좌번호 (자동이체)

    public InsuCarHistForm getForm(FormBase formBase, String insuNum, String carNumber){
        InsuCarHistForm form = new InsuCarHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setCarNumber(carNumber);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setFaceAmt(faceAmt);
        form.setPaidInCnt(paidInCnt);
        form.setPaidAmt(paidAmt);
        form.setPayMethod(payMethod);
        form.setPayOrgCode(payOrgCode);
        form.setPayAccountNum(payAccountNum);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
