package com.abcc.mydataapi.api.base.elec.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpaySearch extends SearchDto {
    private String fobId;    // 권면 ID

    public ElecPpaySearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ElecPpaySearch(String memberId, String orgCd, String fobId) {
        super(memberId, orgCd);
        this.fobId = fobId;
    }

    public ElecPpaySearch(ElecPpayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.fobId = entity.getFobId();
    }

    public ElecPpaySearch(ElecPpayForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.fobId = form.getFobId();
    }
}
