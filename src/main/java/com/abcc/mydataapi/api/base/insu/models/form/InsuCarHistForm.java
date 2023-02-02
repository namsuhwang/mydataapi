package com.abcc.mydataapi.api.base.insu.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuCarHistForm extends FormBase {
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private Long faceAmt;    // 자동차보험 보험료
    private Integer paidInCnt;    // 납입회차
    private Long paidAmt;    // 실납입 보험료
    private String payMethod;    // 수금방법 (코드)
    private String payOrgCode;    // 납입기관(코 드)
    private String payAccountNum;    // 납입 계좌번호 (자동이체)

    public InsuCarHistEntity getEntity(){
        InsuCarHistEntity entity = new InsuCarHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setCarNumber(carNumber);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setFaceAmt(faceAmt);
        entity.setPaidInCnt(paidInCnt);
        entity.setPaidAmt(paidAmt);
        entity.setPayMethod(payMethod);
        entity.setPayOrgCode(payOrgCode);
        entity.setPayAccountNum(payAccountNum);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
