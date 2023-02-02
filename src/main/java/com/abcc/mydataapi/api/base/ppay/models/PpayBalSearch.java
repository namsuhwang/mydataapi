package com.abcc.mydataapi.api.base.ppay.models;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
