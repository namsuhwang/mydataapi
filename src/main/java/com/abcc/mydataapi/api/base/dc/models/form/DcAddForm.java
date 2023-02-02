package com.abcc.mydataapi.api.base.dc.models.form;

import com.abcc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcAddForm extends FormBase {
    private String dcNum;    // 상품관리번호
    private String prodName;    // 개별운용상품명
    private String prodNum;    // 상품가입번호
    private String prodType;    // 상품유형 (코드)
    private BigDecimal evalAmt;    // 평가금액
    private BigDecimal principalAmt;    // 납입(투자)원금
    private BigDecimal holdingNum;    // 보유좌수
    private String issueDate;    // 신규일
    private String expDate;    // 만기일
    private Float intRate;    // 약정이자율

    public DcAddEntity getEntity(){
        DcAddEntity entity = new DcAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setDcNum(dcNum);
        entity.setProdName(prodName);
        entity.setProdNum(prodNum);
        entity.setProdType(prodType);
        entity.setEvalAmt(evalAmt);
        entity.setPrincipalAmt(principalAmt);
        entity.setHoldingNum(holdingNum);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setIntRate(intRate);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
