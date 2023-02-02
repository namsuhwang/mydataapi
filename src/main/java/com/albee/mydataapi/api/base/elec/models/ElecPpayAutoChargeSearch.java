package com.albee.mydataapi.api.base.elec.models;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpayAutoChargeSearch extends SearchDto {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)

    public ElecPpayAutoChargeSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ElecPpayAutoChargeSearch(String memberId, String orgCd, String fobId, String accountId, Integer autoChargeSeq, String chargeOrgCode) {
        super(memberId, orgCd);
        this.fobId = fobId;
        this.accountId = accountId;
        this.autoChargeSeq = autoChargeSeq;
        this.chargeOrgCode = chargeOrgCode;
    }

    public ElecPpayAutoChargeSearch(ElecPpayAutoChargeEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.fobId = entity.getFobId();
        this.accountId = entity.getAccountId();
        this.autoChargeSeq = entity.getAutoChargeSeq();
        this.chargeOrgCode = entity.getChargeOrgCode();
    }

    public ElecPpayAutoChargeSearch(ElecPpayAutoChargeForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.fobId = form.getFobId();
        this.accountId = form.getAccountId();
        this.autoChargeSeq = form.getAutoChargeSeq();
        this.chargeOrgCode = form.getChargeOrgCode();
    }
}
