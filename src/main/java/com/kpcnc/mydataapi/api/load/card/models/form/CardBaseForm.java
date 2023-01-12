package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardBaseForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String cardId;    // 카드 식별자
    private String isTransPayable;    // 교통기능(여부)
    private String isCashCard;    // 현금카드기능 (여부)
    private String linkedBankCode;    // 결제은행 (코드)
    private String accountNum;    // 결제계좌번호
    private String cardBrand;    // 카드브랜드 (코드)
    private Long annualFee;    // 상품 연회비
    private String issueDate;    // 발급일자
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardBaseEntity getEntity(){
        CardBaseEntity entity = new CardBaseEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setCardId(cardId);
        entity.setIsTransPayable(isTransPayable);
        entity.setIsCashCard(isCashCard);
        entity.setLinkedBankCode(linkedBankCode);
        entity.setAccountNum(accountNum);
        entity.setCardBrand(cardBrand);
        entity.setAnnualFee(annualFee);
        entity.setIssueDate(issueDate);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
