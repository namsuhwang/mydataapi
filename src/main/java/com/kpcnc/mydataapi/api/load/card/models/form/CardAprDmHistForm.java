package com.kpcnc.mydataapi.api.load.card.models.form;

import com.kpcnc.mydataapi.api.load.card.models.entity.CardAprDmHistEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardAprDmHistForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String approvedDtime;    // 승인일시
    private String approvedNum;    // 승인번호
    private String status;    // 결제상태 (코드)
    private String payType;    // 사용구분 (신용/체크) (코드)
    private String transDtime;    // 정정 또는 승인취소 일시
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번호
    private Long approvedAmt;    // 이용금액
    private Long modifiedAmt;    // 정정후 금액
    private Integer totalInstallCnt;    // 전체 할부회차
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public CardAprDmHistEntity getEntity(){
        CardAprDmHistEntity entity = new CardAprDmHistEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setApprovedDtime(approvedDtime);
        entity.setApprovedNum(approvedNum);
        entity.setStatus(status);
        entity.setPayType(payType);
        entity.setTransDtime(transDtime);
        entity.setMerchantName(merchantName);
        entity.setMerchantRegno(merchantRegno);
        entity.setApprovedAmt(approvedAmt);
        entity.setModifiedAmt(modifiedAmt);
        entity.setTotalInstallCnt(totalInstallCnt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
