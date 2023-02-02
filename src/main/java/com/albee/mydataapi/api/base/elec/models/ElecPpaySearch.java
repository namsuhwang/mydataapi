package com.albee.mydataapi.api.base.elec.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
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
