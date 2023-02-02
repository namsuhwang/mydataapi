package com.abcc.mydataapi.api.base.tele.models;

import com.abcc.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.abcc.mydataapi.api.base.tele.models.form.TeleContForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeleContSearch extends SearchDto {
    private String mgmtId;    // 계약관리번호

    public TeleContSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public TeleContSearch(String memberId, String orgCd, String mgmtId) {
        super(memberId, orgCd);
        this.mgmtId = mgmtId;
    }

    public TeleContSearch(TeleContEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.mgmtId = entity.getMgmtId();
    }

    public TeleContSearch(TeleContForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.mgmtId = form.getMgmtId();
    }
}
