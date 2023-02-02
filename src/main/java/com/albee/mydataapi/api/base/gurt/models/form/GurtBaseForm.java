package com.albee.mydataapi.api.base.gurt.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtBaseForm extends FormBase {
    private String insuNum;    // 증권번호
    private String issueDate;    // 계약체결일
    private String expDate;    // 종료일자
    private BigDecimal faceAmt;    // 보험가입금액
    private String payDue;    // 납입기간구분(코드)
    private BigDecimal payAmt;    // 총 납입 보험료
    private Integer insuredCnt;    // 피보험자수 

    public GurtBaseEntity getEntity(){
        GurtBaseEntity entity = new GurtBaseEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setIssueDate(issueDate);
        entity.setExpDate(expDate);
        entity.setFaceAmt(faceAmt);
        entity.setPayDue(payDue);
        entity.setPayAmt(payAmt);
        entity.setInsuredCnt(insuredCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
