package com.kpcnc.mydataapi.api.base.ppay.models;

import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PpayHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String ppId;    // 선불카드 식별자
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래유형 (코드)

    public PpayHistSearch(String memberId, String orgCd, String ppId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.ppId = ppId;
    }

    public PpayHistSearch(String memberId, String orgCd, String ppId, String transDtime, String transType) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.ppId = ppId;
        this.transDtime = transDtime;
        this.transType = transType;
    }

    public PpayHistSearch(PpayHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.ppId = entity.getPpId();
        this.transDtime = entity.getTransDtime();
        this.transType = entity.getTransType();
    }

    public PpayHistSearch(PpayHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.ppId = form.getPpId();
        this.transDtime = form.getTransDtime();
        this.transType = form.getTransType();
    }
}
