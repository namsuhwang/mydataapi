package com.albee.mydataapi.api.base.gurt.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GurtHistForm extends FormBase {
    private String insuNum;    // 증권번호
    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)

    public GurtHistEntity getEntity(){
        GurtHistEntity entity = new GurtHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setPaidInCnt(paidInCnt);
        entity.setTransDate(transDate);
        entity.setPaidAmt(paidAmt);
        entity.setPayMethod(payMethod);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
