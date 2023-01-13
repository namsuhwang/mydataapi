package com.kpcnc.mydataapi.api.base.card.models.form;

import com.kpcnc.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardOsPcaForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호
    private String purchaseDate;    // 매입일자
    private String salesDate;    // 매출일자
    private String priApprovedNum;    // 원승인번호
    private String priApprovedDtime;    // 원승인일시
    private BigDecimal priApprovedAmt;    // 원승인금액
    private Long priKrwAmt;    // 원승인금액 원화
    private String priCurrencyCode;    // 원승인금액 통화코드
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String merchantName;    // 가맹점명
    private BigDecimal approvedAmt;    // 이용금액
    private String countryCode;    // 결제(매입) 국가코드
    private String currencyCode;    // 결제(매입) 시 통화코드
    private Long krwAmt;    // 원화
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardOsPcaEntity getEntity(){
        CardOsPcaEntity entity = new CardOsPcaEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setCardId(cardId);
        entity.setPurchaseNum(purchaseNum);
        entity.setPurchaseDate(purchaseDate);
        entity.setSalesDate(salesDate);
        entity.setPriApprovedNum(priApprovedNum);
        entity.setPriApprovedDtime(priApprovedDtime);
        entity.setPriApprovedAmt(priApprovedAmt);
        entity.setPriKrwAmt(priKrwAmt);
        entity.setPriCurrencyCode(priCurrencyCode);
        entity.setPayType(payType);
        entity.setMerchantName(merchantName);
        entity.setApprovedAmt(approvedAmt);
        entity.setCountryCode(countryCode);
        entity.setCurrencyCode(currencyCode);
        entity.setKrwAmt(krwAmt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
