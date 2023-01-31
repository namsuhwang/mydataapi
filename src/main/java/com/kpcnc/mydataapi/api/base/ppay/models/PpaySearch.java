package com.kpcnc.mydataapi.api.base.ppay.models;

import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PpaySearch extends SearchDto {
    private String ppId;    // 선불카드 식별자

    public PpaySearch(String memberId, String orgCd, String ppId) {
        super(memberId, orgCd);
        this.ppId = ppId;
    }

    public PpaySearch(PpayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.ppId = entity.getPpId();
    }

    public PpaySearch(PpayForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.ppId = form.getPpId();
    }
}
