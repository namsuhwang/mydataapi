package com.abcc.mydataapi.api.base.card.models.form;

import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;
import com.abcc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardDmPcaForm extends FormBase {
    private String cardId;    // 카드 식별자
    private String purchaseNum;    // 매입번호
    private String purchaseDate;    // 매입일자
    private String salesDate;    // 매출일자
    private String priApprovedNum;    // 원승인번호
    private String priApprovedDtime;    // 원승인일시
    private BigDecimal priApprovedAmt;    // 원승인금액
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번호
    private BigDecimal approvedAmt;    // 이용금액
    private Integer totalInstallCnt;    // 전체 할부회차

    public CardDmPcaEntity getEntity(){
        CardDmPcaEntity entity = new CardDmPcaEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setCardId(cardId);
        entity.setPurchaseNum(purchaseNum);
        entity.setPurchaseDate(purchaseDate);
        entity.setSalesDate(salesDate);
        entity.setPriApprovedNum(priApprovedNum);
        entity.setPriApprovedDtime(priApprovedDtime);
        entity.setPriApprovedAmt(priApprovedAmt);
        entity.setPayType(payType);
        entity.setMerchantName(merchantName);
        entity.setMerchantRegno(merchantRegno);
        entity.setApprovedAmt(approvedAmt);
        entity.setTotalInstallCnt(totalInstallCnt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
