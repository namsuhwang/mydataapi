package com.albee.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.ppay.models.form.PpayAprHistForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Ppay004ResDetailDto {

    private String approvedNum;    // 승인번호
    private String approvedDtime;    // 승인일시
    private String status;    // 결제상태 (코드)
    private String transDtime;    // 정정 또는 승인취소일시
    private String merchantName;    // 가맹점명
    private String merchantRegno;    // 가맹점 사업자등록번 호
    private Long approvedAmt;    // 이용금액
    private Long modifiedAmt;    // 정정후 금액
    private Integer totalInstallCnt;    // 전체 할부회차

    public PpayAprHistForm getForm(FormBase formBase, String ppId){
        PpayAprHistForm form = new PpayAprHistForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setPpId(ppId);
        form.setApprovedNum(approvedNum);
        form.setApprovedDtime(approvedDtime);
        form.setStatus(status);
        form.setTransDtime(transDtime);
        form.setMerchantName(merchantName);
        form.setMerchantRegno(merchantRegno);
        form.setApprovedAmt(approvedAmt);
        form.setModifiedAmt(modifiedAmt);
        form.setTotalInstallCnt(totalInstallCnt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
