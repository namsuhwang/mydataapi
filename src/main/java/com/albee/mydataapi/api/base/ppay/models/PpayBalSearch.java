package com.albee.mydataapi.api.base.ppay.models;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class PpayBalSearch extends SearchDto {
    private String ppId;    // 선불카드 식별자

    public PpayBalSearch(String memberId, String orgCd, String ppId) {
        super(memberId, orgCd);
        this.ppId = ppId;
    }

    public PpayBalSearch(PpayBalEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.ppId = entity.getPpId();
    }

    public PpayBalSearch(PpayBalForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.ppId = form.getPpId();
    }
}
