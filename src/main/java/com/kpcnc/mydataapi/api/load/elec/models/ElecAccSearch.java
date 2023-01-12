package com.kpcnc.mydataapi.api.load.elec.models;

import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecAccForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecAccSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String subKey;    // Sub key
    private String accountId;    // 계정식별값

    public ElecAccSearch(String memberId, String orgCd, String subKey, String accountId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.subKey = subKey;
        this.accountId = accountId;
    }

    public ElecAccSearch(ElecAccEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.subKey = entity.getSubKey();
        this.accountId = entity.getAccountId();
    }

    public ElecAccSearch(ElecAccForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.subKey = form.getSubKey();
        this.accountId = form.getAccountId();
    }
}
