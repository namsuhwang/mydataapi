package com.albee.mydataapi.api.base.elec.models;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAccForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ElecPpayAccSearch extends SearchDto {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값

    public ElecPpayAccSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ElecPpayAccSearch(String memberId, String orgCd, String fobId, String accountId) {
        super(memberId, orgCd);
        this.fobId = fobId;
        this.accountId = accountId;
    }

    public ElecPpayAccSearch(ElecPpayAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.fobId = entity.getFobId();
        this.accountId = entity.getAccountId();
    }

    public ElecPpayAccSearch(ElecPpayAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.fobId = form.getFobId();
        this.accountId = form.getAccountId();
    }
}
