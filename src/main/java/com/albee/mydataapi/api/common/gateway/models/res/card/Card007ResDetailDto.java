package com.albee.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.card.models.form.CardRvForm;
import com.albee.mydataapi.common.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Card007ResDetailDto {

    private String reqDate;    // 리볼빙약정 시작일
    private String endDate;    // 리볼빙약정 종료일
    private String closeDate;    // 리볼빙 해지일자
    private Float minPayRate;    // 최소결제비율
    private Long minPayAmt;    // 최소결제금액
    private Float agreedPayRate;    // 약정결제비율
    private Long agreedPayAmt;    // 약정결제금액
    private Long remainedAmt;    // 리볼빙 이월잔액

    public CardRvForm getForm(FormBase formBase){
        CardRvForm form = new CardRvForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setReqDate(reqDate);
        form.setEndDate(endDate);
        form.setCloseDate(closeDate);
        form.setMinPayRate(minPayRate);
        form.setAgreedPayRate(agreedPayRate);
        form.setAgreedPayAmt(agreedPayAmt);
        form.setRemainedAmt(remainedAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
