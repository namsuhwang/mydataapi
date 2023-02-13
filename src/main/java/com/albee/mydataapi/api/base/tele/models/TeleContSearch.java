package com.albee.mydataapi.api.base.tele.models;

import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
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
