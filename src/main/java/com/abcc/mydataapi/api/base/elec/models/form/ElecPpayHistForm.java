package com.abcc.mydataapi.api.base.elec.models.form;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayHistForm extends FormBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형(코드)
    private BigDecimal transAmt;    // 거래금액
    private BigDecimal balanceAmt;    // 거래 후 잔액
    private String transOrgCode;    // 거래상대 기관(코드)
    private String transId;    // 거래상대 식별값
    private String transNum;    // 주문번호
    private String transMemo;    // 거래메모
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점사업자 등록번호
    private String transTitle;    // 상품(구매)제 목
    private String transCategory;    // 상품(구매)분 류 (코드)
    private String payMethod;    // 결제방법 (코드)
    private String isScheduled;    // 정기결제여부

    public ElecPpayHistEntity getEntity(){
        ElecPpayHistEntity entity = new ElecPpayHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setFobId(fobId);
        entity.setAccountId(accountId);
        entity.setTransDtime(transDtime);
        entity.setTransNo(transNo);
        entity.setTransType(transType);
        entity.setTransAmt(transAmt);
        entity.setBalanceAmt(balanceAmt);
        entity.setTransOrgCode(transOrgCode);
        entity.setTransId(transId);
        entity.setTransNum(transNum);
        entity.setTransMemo(transMemo);
        entity.setMerchantName(merchantName);
        entity.setMerchantRegno(merchantRegno);
        entity.setTransTitle(transTitle);
        entity.setTransCategory(transCategory);
        entity.setPayMethod(payMethod);
        entity.setIsScheduled(isScheduled);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
