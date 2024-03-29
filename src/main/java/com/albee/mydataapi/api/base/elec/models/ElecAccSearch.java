package com.albee.mydataapi.api.base.elec.models;

import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecAccForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ElecAccSearch extends SearchDto {
    private String subKey;    // Sub key
    private String accountId;    // 계정식별값

    public ElecAccSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ElecAccSearch(String memberId, String orgCd, String subKey, String accountId) {
        super(memberId, orgCd);
        this.subKey = subKey;
        this.accountId = accountId;
    }

    public ElecAccSearch(ElecAccEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.subKey = entity.getSubKey();
        this.accountId = entity.getAccountId();
    }

    public ElecAccSearch(ElecAccForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.subKey = form.getSubKey();
        this.accountId = form.getAccountId();
    }
}
