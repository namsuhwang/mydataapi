package com.albee.mydataapi.api.base.tele.models;

import com.albee.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class TeleHistSearch extends SearchDto {
    private String mgmtId;    // 계약관리번호

    public TeleHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public TeleHistSearch(String memberId, String orgCd, String mgmtId) {
        super(memberId, orgCd);
        this.mgmtId = mgmtId;
    }

    public TeleHistSearch(TeleHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.mgmtId = entity.getMgmtId();
    }

    public TeleHistSearch(TeleHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.mgmtId = form.getMgmtId();
    }
}
