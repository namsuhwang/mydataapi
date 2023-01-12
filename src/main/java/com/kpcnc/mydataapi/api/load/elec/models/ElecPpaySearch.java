package com.kpcnc.mydataapi.api.load.elec.models;

import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpaySearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID

    public ElecPpaySearch(String memberId, String orgCd, String fobId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.fobId = fobId;
    }

    public ElecPpaySearch(ElecPpayEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.fobId = entity.getFobId();
    }

    public ElecPpaySearch(ElecPpayForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.fobId = form.getFobId();
    }
}
