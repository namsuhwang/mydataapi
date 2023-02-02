package com.abcc.mydataapi.api.base.tele.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.tele.models.entity.TelePayEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TelePayForm extends FormBase {
    private String mgmtId;    // 계약관리번호
    private String transDate;    // 이용일시
    private BigDecimal transAmt;    // 결제금액
    private String orgRegno;    // 가맹점 사업자번호
    private String merchantName;    // 가맹점명
    private String transTitle;    // 결제상품명

    public TelePayEntity getEntity(){
        TelePayEntity entity = new TelePayEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setMgmtId(mgmtId);
        entity.setTransDate(transDate);
        entity.setTransAmt(transAmt);
        entity.setOrgRegno(orgRegno);
        entity.setMerchantName(merchantName);
        entity.setTransTitle(transTitle);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
