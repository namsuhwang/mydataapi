package com.kpcnc.mydataapi.api.common.recv.models.form;

import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvHistBaseForm{
    private String recvSeq;    // 수신 일련번호. RecvStatus.recvSeq와 동일.
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String apiId;    // API ID
    private String recvStartDt;    // 수신 시작 일시
    private String recvEndDt;    // 수신 종료 일시
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public RecvHistBaseForm(String memberId, String orgCd, String apiId, String recvSeq) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.apiId = apiId;
        this.recvSeq = recvSeq;
    }

    public RecvHistBaseEntity getEntity(){
        RecvHistBaseEntity entity = new RecvHistBaseEntity();
        entity.setRecvSeq(recvSeq);
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setApiId(apiId);
        entity.setRecvStartDt(recvStartDt);
        entity.setRecvEndDt(recvEndDt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
