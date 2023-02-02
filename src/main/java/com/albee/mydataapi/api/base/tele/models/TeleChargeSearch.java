package com.albee.mydataapi.api.base.tele.models;

import com.albee.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeleChargeSearch extends SearchDto {
    private String mgmtId;    // 계약관리번호

    public TeleChargeSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public TeleChargeSearch(String memberId, String orgCd, String mgmtId) {
        super(memberId, orgCd);
        this.mgmtId = mgmtId;
    }

    public TeleChargeSearch(TeleChargeEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.mgmtId = entity.getMgmtId();
    }

    public TeleChargeSearch(TeleChargeForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.mgmtId = form.getMgmtId();
    }
}
