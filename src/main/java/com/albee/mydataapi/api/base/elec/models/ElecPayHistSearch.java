package com.albee.mydataapi.api.base.elec.models;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class ElecPayHistSearch extends SearchDto {
    private String subKey;    // Sub key
    private String transDtime;    // 결제일시 또는 결제취소일시
    private String transNo;    // 결제번호

    public ElecPayHistSearch(String memberId, String orgCd, String subKey) {
        super(memberId, orgCd);
        this.subKey = subKey;
    }


    public ElecPayHistSearch(String memberId, String orgCd, String subKey, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.subKey = subKey;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public ElecPayHistSearch(ElecPayHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.subKey = entity.getSubKey();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public ElecPayHistSearch(ElecPayHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.subKey = form.getSubKey();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
