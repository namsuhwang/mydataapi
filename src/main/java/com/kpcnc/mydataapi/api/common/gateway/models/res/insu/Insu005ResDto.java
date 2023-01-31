package com.kpcnc.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Insu005ResDto extends ResBaseDto {

    private String payDue;    // 납입기간구분 (코드)
    private String payCycle;    // 납입주기 (코드)
    private Integer payCnt;    // 총 납입 횟수
    private String payOrgCode;    // 납입기관(코 드)
    private String payAccountNum;    // 납입 계좌번호 (자동이체)
    private String payDate;    // 납입일자
    private String payEndDate;    // 납입종료일자
    private BigDecimal payAmt;    // 납입 보험료
    private String currencyCode;    // 통화코드(납 입 보험료)
    private Boolean isAutoPay;    // 자동대출납입 신청 여부

    public InsuPayForm getForm(FormBase formBase, String insuNum){
        InsuPayForm form = new InsuPayForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setPayDue(payDue);
        form.setPayCycle(payCycle);
        form.setPayCnt(payCnt);
        form.setPayOrgCode(payOrgCode);
        form.setPayAccountNum(payAccountNum);
        form.setPayDate(payDate);
        form.setPayAmt(payAmt);
        form.setCurrencyCode(currencyCode);
        form.setIsAutoPay(isAutoPay ? "Y" : "N");
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
