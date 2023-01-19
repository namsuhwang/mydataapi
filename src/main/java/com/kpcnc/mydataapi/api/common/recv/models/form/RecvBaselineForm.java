package com.kpcnc.mydataapi.api.common.recv.models.form;

import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvBaselineForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID
    private String apiTranDay;    // 거래일자
    private String apiTranId;    // 거래고유번호
    private Long searchTimeStamp;    // 조회타임스탬프
    private String nextPage;    // 최종 수신 데이터
    private String lastRecvDt;    // 최종 수신 일시
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public RecvBaselineForm(String memberId, String orgCd, String apiId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
        this.regUserId = "user01";
        this.chgUserId = "user01";
    }

    public RecvBaselineEntity getEntity(){
        RecvBaselineEntity entity = new RecvBaselineEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setApiId(apiId);
        entity.setApiTranDay(apiTranDay);
        entity.setApiTranId(apiTranId);
        entity.setNextPage(nextPage);
        entity.setLastRecvDt(lastRecvDt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
