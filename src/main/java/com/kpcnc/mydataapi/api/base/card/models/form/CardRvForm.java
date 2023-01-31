package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardRvForm extends FormBase {
    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일
    private String closeDate;    // 리볼빙 해지일자
    private Float minPayRate;    // 최소결제비율
    private Long minPayAmt;    // 최소결제금액
    private Float agreedPayRate;    // 약정결제비율
    private Long agreedPayAmt;    // 약정결제금액
    private Long remainedAmt;    // 리볼빙 이월잔액

    public CardRvEntity getEntity(){
        CardRvEntity entity = new CardRvEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setReqDate(reqDate);
        entity.setEndDate(endDate);
        entity.setCloseDate(closeDate);
        entity.setMinPayRate(minPayRate);
        entity.setMinPayAmt(minPayAmt);
        entity.setAgreedPayRate(agreedPayRate);
        entity.setAgreedPayAmt(agreedPayAmt);
        entity.setRemainedAmt(remainedAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
