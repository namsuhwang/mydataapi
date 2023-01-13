package com.kpcnc.mydataapi.api.base.tele.models;

import com.kpcnc.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.kpcnc.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TeleHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호

    public TeleHistSearch(String memberId, String orgCd, String mgmtId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.mgmtId = mgmtId;
    }

    public TeleHistSearch(TeleHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.mgmtId = entity.getMgmtId();
    }

    public TeleHistSearch(TeleHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.mgmtId = form.getMgmtId();
    }
}
