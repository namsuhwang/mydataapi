package com.abcc.mydataapi.api.base.ppay.models;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayAprHistForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PpayAprHistSearch extends SearchDto {
    private String ppId;    // 선불카드 식별자
    private String approvedNum;    // 승인번호
    private String approvedDtime;    // 승인일시
    private String status;    // 결제상태 (코드)
    private String transDtime;    // 정정 또는 승인취소일시

    public PpayAprHistSearch(String memberId, String orgCd, String ppId) {
        super(memberId, orgCd);
        this.ppId = ppId;
    }

    public PpayAprHistSearch(String memberId, String orgCd, String ppId, String approvedNum, String approvedDtime, String status, String transDtime) {
        super(memberId, orgCd);
        this.ppId = ppId;
        this.approvedNum = approvedNum;
        this.approvedDtime = approvedDtime;
        this.status = status;
        this.transDtime = transDtime;
    }

    public PpayAprHistSearch(PpayAprHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.ppId = entity.getPpId();
        this.approvedNum = entity.getApprovedNum();
        this.approvedDtime = entity.getApprovedDtime();
        this.status = entity.getStatus();
        this.transDtime = entity.getTransDtime();
    }

    public PpayAprHistSearch(PpayAprHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.ppId = form.getPpId();
        this.approvedNum = form.getApprovedNum();
        this.approvedDtime = form.getApprovedDtime();
        this.status = form.getStatus();
        this.transDtime = form.getTransDtime();
    }
}
