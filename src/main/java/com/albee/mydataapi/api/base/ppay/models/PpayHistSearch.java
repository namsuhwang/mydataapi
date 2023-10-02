package com.albee.mydataapi.api.base.ppay.models;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.albee.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PpayHistSearch extends SearchDto {
    private String ppId;    // 선불카드 식별자
    private String transDtime;    // 거래일시 또는 거래일자
    private String transType;    // 거래유형 (코드)

    public PpayHistSearch(String memberId, String orgCd, String ppId) {
        super(memberId, orgCd);
        this.ppId = ppId;
    }

    public PpayHistSearch(String memberId, String orgCd, String ppId, String transDtime, String transType) {
        super(memberId, orgCd);
        this.ppId = ppId;
        this.transDtime = transDtime;
        this.transType = transType;
    }

    public PpayHistSearch(PpayHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.ppId = entity.getPpId();
        this.transDtime = entity.getTransDtime();
        this.transType = entity.getTransType();
    }

    public PpayHistSearch(PpayHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.ppId = form.getPpId();
        this.transDtime = form.getTransDtime();
        this.transType = form.getTransType();
    }
}
