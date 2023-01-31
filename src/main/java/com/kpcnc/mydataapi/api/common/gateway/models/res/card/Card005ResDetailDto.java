package com.kpcnc.mydataapi.api.common.gateway.models.res.card;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeAddForm;
import com.kpcnc.mydataapi.api.base.card.models.form.CardChargeForm;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Card005ResDetailDto {

    private String seqno;    // 결제순번
    private String chargeMonth;    // 청구년월
    private String cardId;    // 카드 식별자
    private String paidDtime;    // 사용일시 또는 사용일자
    private String transNo;    // 거래번호
    private BigDecimal paidAmt;    // 이용금액
    private String currencyCode;    // 통화코드 (이용금액)
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번호
    private Long creditFeeAmt;    // 신용판매 수수료
    private Integer totalInstallCnt;    // 전체 할부회차
    private Integer curInstallCnt;    // 현재 할부회차
    private Long balanceAmt;    // 할부 결제 후 잔액
    private String prodType;    // 상품구분 (코드)

    public CardChargeAddForm getForm(FormBase formBase){
        CardChargeAddForm form = new CardChargeAddForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setSeqno(seqno);
        form.setChargeMonth(chargeMonth);
        form.setCardId(cardId);
        form.setPaidDtime(paidDtime);
        form.setTransNo(transNo);
        form.setPaidAmt(paidAmt);
        form.setCurrencyCode(currencyCode);
        form.setMerchantName(merchantName);
        form.setMerchantRegno(merchantRegno);
        form.setCreditFeeAmt(creditFeeAmt);
        form.setTotalInstallCnt(totalInstallCnt);
        form.setCurInstallCnt(curInstallCnt);
        form.setBalanceAmt(balanceAmt);
        form.setProdType(prodType);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
