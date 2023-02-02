package com.abcc.mydataapi.api.common.recv.models;

import com.abcc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
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
    private String apiTranDay;    // 거래일자
    private String apiTranId;    // 거래고유번호
    private String searchTimeStamp;    // 조회타임스탬프
    private String nextPage;    // 최종 수신 데이터

    public RecvBaselineSearch(String memberId, String orgCd, String apiId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
    }

    public RecvBaselineSearch(String apiTranDay, String apiTranId) {
        this.apiTranDay = apiTranDay;
        this.apiTranId = apiTranId;
    }

    public RecvBaselineSearch(String memberId, String orgCd, String apiId, String apiTranDay, String apiTranId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
        this.apiTranDay = apiTranDay;
        this.apiTranId = apiTranId;
    }

    public RecvBaselineSearch(RecvBaselineEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.apiId = entity.getApiId();
        this.apiTranDay = entity.getApiTranDay();
        this.apiTranId = entity.getApiTranId();
    }

    public RecvBaselineSearch(RecvBaselineForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.apiId = form.getApiId();
        this.apiTranDay = form.getApiTranDay();
        this.apiTranId = form.getApiTranId();
    }
}
