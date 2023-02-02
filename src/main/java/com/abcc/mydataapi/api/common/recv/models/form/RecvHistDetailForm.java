package com.abcc.mydataapi.api.common.recv.models.form;

import com.abcc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecvHistDetailForm{
    private String recvSeq;    // 수신 일련번호
    private Long recvDetailSeq;    // 수신 상세 일련번호
    private String recvData;    // 수신데이터
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public RecvHistDetailForm(RecvHistBaseForm baseForm) {
        this.recvSeq = baseForm.getRecvSeq();

        this.regUserId = baseForm.getRegUserId();
        this.regDt = baseForm.getRegDt();
        this.chgUserId = baseForm.getChgUserId();
        this.chgDt = baseForm.getChgDt();
    }

    public RecvHistDetailEntity getEntity(){
        RecvHistDetailEntity entity = new RecvHistDetailEntity();
        entity.setRecvSeq(recvSeq);
        entity.setRecvDetailSeq(recvDetailSeq);
        entity.setRecvData(recvData);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
