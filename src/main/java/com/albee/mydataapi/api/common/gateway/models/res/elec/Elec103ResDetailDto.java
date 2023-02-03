package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.base.elec.models.form.ElecPayHistForm;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Elec103ResDetailDto {

    private String transDtime;    // 결제일시 또는 결제취소일시
    private String transNo;    // 결제번호
    private String transNum;    // 주문번호
    private String transType;    // 결제유형 (코드)
    private String currencyCode;    // 통화코드
    private BigDecimal transAmt;    // 결제금액
    private String transOrgCode;    // 결제수단 기관 (코드)
    private String payType;    // 결제수단 식별코드
    private String payId;    // 결제수단 식별키
    private String approvedNum;    // 카드승인번호
    private String cardName;    // 카드명
    private Integer totalInstallCnt;    // 할부개월
    private String transMemo;    // 거래메모
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번 호
    private String transTitle;    // 상품(구매)제 목
    private String transCategory;    // 상품(구매)분 류 (코드)
    private String payMethod;    // 결제방법 (코드)

    public ElecPayHistForm getForm(FormBase formBase, String subKey){
        ElecPayHistForm form = new ElecPayHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setSubKey(subKey);
        form.setTransDtime(transDtime);
        form.setTransNo(transNo);
        form.setTransNum(transNum);
        form.setTransType(transType);
        form.setCurrencyCode(currencyCode);
        form.setTransAmt(transAmt);
        form.setTransOrgCode(transOrgCode);
        form.setPayType(payType);
        form.setPayId(payId);
        form.setApprovedNum(approvedNum);
        form.setCardName(cardName);
        form.setTotalInstallCnt(totalInstallCnt);
        form.setTransMemo(transMemo);
        form.setMerchantName(merchantName);
        form.setMerchantRegno(merchantRegno);
        form.setTransTitle(transTitle);
        form.setTransCategory(transCategory);
        form.setPayMethod(payMethod);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
