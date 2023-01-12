package com.kpcnc.mydataapi.api.load.elec.models;

import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPayMethodEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPayMethodForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPayMethodSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String subKey;    // Sub key
    private String payOrgCode;    // 결제수단 기관 (코드)

    public ElecPayMethodSearch(String memberId, String orgCd, String subKey, String payOrgCode) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.subKey = subKey;
        this.payOrgCode = payOrgCode;
    }

    public ElecPayMethodSearch(ElecPayMethodEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.subKey = entity.getSubKey();
        this.payOrgCode = entity.getPayOrgCode();
    }

    public ElecPayMethodSearch(ElecPayMethodForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.subKey = form.getSubKey();
        this.payOrgCode = form.getPayOrgCode();
    }
}
