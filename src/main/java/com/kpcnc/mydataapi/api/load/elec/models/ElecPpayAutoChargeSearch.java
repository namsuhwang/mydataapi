package com.kpcnc.mydataapi.api;

import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAutoChargeEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAutoChargeForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpayAutoChargeSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private Integer autoChargeSeq;    // 자동충전일련번호
    private String chargeOrgCode;    // 충전지불수단 기관 (코드)

    public ElecPpayAutoChargeSearch(String memberId, String orgCd, String fobId, String accountId, Integer autoChargeSeq, String chargeOrgCode) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.fobId = fobId;
        this.accountId = accountId;
        this.autoChargeSeq = autoChargeSeq;
        this.chargeOrgCode = chargeOrgCode;
    }

    public ElecPpayAutoChargeSearch(ElecPpayAutoChargeEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.fobId = entity.getFobId();
        this.accountId = entity.getAccountId();
        this.autoChargeSeq = entity.getAutoChargeSeq();
        this.chargeOrgCode = entity.getChargeOrgCode();
    }

    public ElecPpayAutoChargeSearch(ElecPpayAutoChargeForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.fobId = form.getFobId();
        this.accountId = form.getAccountId();
        this.autoChargeSeq = form.getAutoChargeSeq();
        this.chargeOrgCode = form.getChargeOrgCode();
    }
}
