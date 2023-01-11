package com.kpcnc.mydataapi.api.common.recv.models;

import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvHistBaseSearch extends SearchDto {
    private String recvId;    // 수신 ID
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID

    public RecvHistBaseSearch(String recvId, String memberId, String orgCd, String apiId) {
        this.recvId = recvId;
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
    }

    public RecvHistBaseSearch(RecvHistBaseEntity entity) {
        this.recvId = entity.getRecvId();
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.apiId = entity.getApiId();
    }

    public RecvHistBaseSearch(RecvHistBaseForm form) {
        this.recvId = form.getRecvId();
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.apiId = form.getApiId();
    }
}
