package com.abcc.mydataapi.api.base.card.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.card.models.entity.CardChargeAddEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardChargeAddForm extends FormBase {
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

    public CardChargeAddEntity getEntity(){
        CardChargeAddEntity entity = new CardChargeAddEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setSeqno(seqno);
        entity.setChargeMonth(chargeMonth);
        entity.setCardId(cardId);
        entity.setPaidDtime(paidDtime);
        entity.setTransNo(transNo);
        entity.setPaidAmt(paidAmt);
        entity.setCurrencyCode(currencyCode);
        entity.setMerchantName(merchantName);
        entity.setMerchantRegno(merchantRegno);
        entity.setCreditFeeAmt(creditFeeAmt);
        entity.setTotalInstallCnt(totalInstallCnt);
        entity.setCurInstallCnt(curInstallCnt);
        entity.setBalanceAmt(balanceAmt);
        entity.setProdType(prodType);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
