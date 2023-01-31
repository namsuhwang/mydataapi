package com.kpcnc.mydataapi.api.base.tele.models;

import com.kpcnc.mydataapi.api.base.tele.models.entity.TelePayEntity;
import com.kpcnc.mydataapi.api.base.tele.models.form.TelePayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TelePaySearch extends SearchDto {
    private String mgmtId;    // 계약관리번호

    public TelePaySearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public TelePaySearch(String memberId, String orgCd, String mgmtId) {
        super(memberId, orgCd);
        this.mgmtId = mgmtId;
    }

    public TelePaySearch(TelePayEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.mgmtId = entity.getMgmtId();
    }

    public TelePaySearch(TelePayForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.mgmtId = form.getMgmtId();
    }
}
