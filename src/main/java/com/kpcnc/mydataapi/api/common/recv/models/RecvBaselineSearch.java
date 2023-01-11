package com.kpcnc.mydataapi.api.common.recv.models;

import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvBaselineSearch{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID

    public RecvBaselineSearch(String memberId, String orgCd, String apiId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
    }

    public RecvBaselineSearch(RecvBaselineEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.apiId = entity.getApiId();
    }

    public RecvBaselineSearch(RecvBaselineForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.apiId = form.getApiId();
    }
}
