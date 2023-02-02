package com.abcc.mydataapi.api.common.recv.models;

import com.abcc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvHistBaseSearch extends SearchDto {
    private String recvSeq;    // 수신 일련번호
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID

    public RecvHistBaseSearch(String recvSeq, String memberId, String orgCd, String apiId) {
        this.recvSeq = recvSeq;
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
    }

    public RecvHistBaseSearch(RecvHistBaseEntity entity) {
        this.recvSeq = entity.getRecvSeq();
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.apiId = entity.getApiId();
    }

    public RecvHistBaseSearch(RecvHistBaseForm form) {
        this.recvSeq = form.getRecvSeq();
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.apiId = form.getApiId();
    }
}
