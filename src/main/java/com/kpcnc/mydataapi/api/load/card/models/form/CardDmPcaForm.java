package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardDmPcaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardDmPcaForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
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
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardDmPcaEntity getEntity(){
        CardDmPcaEntity entity = new CardDmPcaEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
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
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
