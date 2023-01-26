package com.kpcnc.mydataapi.api.base.dc.models.form;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcHistForm extends FormBase {
    private String dcNum;    // 상품관리번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래구분 (코드)
    private BigDecimal transAmt;    // 거래금액

    public DcHistEntity getEntity(){
        DcHistEntity entity = new DcHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setDcNum(dcNum);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransAmt(transAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
