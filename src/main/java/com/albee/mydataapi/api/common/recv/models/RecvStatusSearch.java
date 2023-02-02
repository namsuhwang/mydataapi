package com.albee.mydataapi.api.common.recv.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvStatusSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String recvDay;    // 수신 일자
    private String recvSeq;    // 수신 일련번호

    public RecvStatusSearch(String memberId, String recvDay, String recvSeq) {
        this.memberId = memberId;
        this.recvDay = recvDay;
        this.recvSeq = recvSeq;
    }

    public RecvStatusSearch(RecvStatusEntity entity) {
        this.memberId = entity.getMemberId();
        this.recvDay = entity.getRecvDay();
        this.recvSeq = entity.getRecvSeq();
    }

    public RecvStatusSearch(RecvStatusForm form) {
        this.memberId = form.getMemberId();
        this.recvDay = form.getRecvDay();
        this.recvSeq = form.getRecvSeq();
    }
}
