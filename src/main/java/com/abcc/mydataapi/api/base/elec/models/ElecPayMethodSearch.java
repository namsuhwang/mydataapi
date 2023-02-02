package com.abcc.mydataapi.api.base.elec.models;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPayMethodForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPayMethodSearch extends SearchDto {
    private String subKey;    // Sub key
    private String payOrgCode;    // 결제수단 기관 (코드)

    public ElecPayMethodSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public ElecPayMethodSearch(String memberId, String orgCd, String subKey, String payOrgCode) {
        super(memberId, orgCd);
        this.subKey = subKey;
        this.payOrgCode = payOrgCode;
    }

    public ElecPayMethodSearch(ElecPayMethodEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.subKey = entity.getSubKey();
        this.payOrgCode = entity.getPayOrgCode();
    }

    public ElecPayMethodSearch(ElecPayMethodForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.subKey = form.getSubKey();
        this.payOrgCode = form.getPayOrgCode();
    }
}
