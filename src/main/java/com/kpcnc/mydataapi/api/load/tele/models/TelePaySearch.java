package com.kpcnc.mydataapi.api.load.tele.models;

import com.kpcnc.mydataapi.api.load.tele.models.entity.TelePayEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TelePayForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TelePaySearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호

    public TelePaySearch(String memberId, String orgCd, String mgmtId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.mgmtId = mgmtId;
    }

    public TelePaySearch(TelePayEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.mgmtId = entity.getMgmtId();
    }

    public TelePaySearch(TelePayForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.mgmtId = form.getMgmtId();
    }
}
