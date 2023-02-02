package com.albee.mydataapi.api.common.recv.models.form;

import com.albee.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvStatusForm{
    private String memberId;    // 회원ID
    private String recvDay;    // 수신 일자
    private String recvSeq;    // 수신 일련번호
    private Integer targetOrgCnt;    // 대상 기관수
    private Integer completeOrgCnt;    // 완료 기관수
    private Integer incOrgCnt;    // 처리완료로 증가시킬 기관수
    private String recvStatus;    // 수신 상태
    private String recvStartDt;    // 수신 시작 일시
    private String recvEndDt;    // 수신 종료 일시
    private String lastRecvOrgCd;    // 최종 수신 기관코드
    private String lastRecvDt;    // 최종 갱신 일시
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public RecvStatusEntity getEntity(){
        RecvStatusEntity entity = new RecvStatusEntity();
        entity.setMemberId(memberId);
        entity.setRecvDay(recvDay);
        entity.setRecvSeq(recvSeq);
        entity.setTargetOrgCnt(targetOrgCnt);
        entity.setCompleteOrgCnt(completeOrgCnt);
        entity.setRecvStatus(recvStatus);
        entity.setRecvStartDt(recvStartDt);
        entity.setRecvEndDt(recvEndDt);
        entity.setLastRecvOrgCd(lastRecvOrgCd);
        entity.setLastRecvDt(lastRecvDt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
