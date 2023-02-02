package com.albee.mydataapi.api.base.itfn.models.form;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnLoanHistIntForm extends FormBase {
    private String accountNum;    // 계좌번호
    private String seqno;    // 회차번호
    private String transDtime;    // 거래일시
    private String transNo;    // 거래번호
    private String intStartDate;    // 이자적용시작일
    private String intEndDate;    // 이자적용종료일
    private Float intRate;    // 적용이율
    private BigDecimal appliedIntAmt;    // 이자금액
    private String intType;    // 이자종류(코드)
    private BigDecimal intAmt;    // 거래금액 중 이자

    public ItfnLoanHistIntEntity getEntity(){
        ItfnLoanHistIntEntity entity = new ItfnLoanHistIntEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setAccountNum(accountNum);
        entity.setSeqno(seqno);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setIntStartDate(intStartDate);
        entity.setIntEndDate(intEndDate);
        entity.setIntRate(intRate);
        entity.setAppliedIntAmt(appliedIntAmt);
        entity.setIntType(intType);
        entity.setIntAmt(intAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
