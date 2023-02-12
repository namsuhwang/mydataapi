package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.common.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanHistIntForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String transNo;    // 거래번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String intStartDate;    // 이자적용시작 일
    private String intEndDate;    // 이자적용종료 일
    private Float intRate;    // 적용이율
    private String intType;    // 이자종류 (코드)

    public InsuLoanHistIntEntity getEntity(){
        InsuLoanHistIntEntity entity = new InsuLoanHistIntEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setTransNo(transNo);
        entity.setTransDtime(transDtime);
        entity.setIntStartDate(intStartDate);
        entity.setIntEndDate(intEndDate);
        entity.setIntRate(intRate);
        entity.setIntType(intType);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
