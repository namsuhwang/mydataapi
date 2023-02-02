package com.albee.mydataapi.api.base.card.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.card.models.entity.CardAprDmHistEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardAprDmHistForm extends FormBase {
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

    public CardAprDmHistEntity getEntity(){
        CardAprDmHistEntity entity = new CardAprDmHistEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
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
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
