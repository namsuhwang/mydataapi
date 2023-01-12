package com.kpcnc.mydataapi.api.load.elec.models;

import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayBalEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayBalForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpayBalSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값

    public ElecPpayBalSearch(String memberId, String orgCd, String fobId, String accountId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.fobId = fobId;
        this.accountId = accountId;
    }

    public ElecPpayBalSearch(ElecPpayBalEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.fobId = entity.getFobId();
        this.accountId = entity.getAccountId();
    }

    public ElecPpayBalSearch(ElecPpayBalForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.fobId = form.getFobId();
        this.accountId = form.getAccountId();
    }
}
