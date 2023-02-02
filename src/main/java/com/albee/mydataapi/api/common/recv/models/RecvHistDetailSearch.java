package com.albee.mydataapi.api.common.recv.models;

import com.albee.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvHistDetailSearch extends SearchDto {
    private String recvSeq;    // 수신 일련번호
    private Long recvDetailSeq;    // 수신 상세 일련번호

    public RecvHistDetailSearch(String recvSeq, Long recvDetailSeq) {
        this.recvSeq = recvSeq;
        this.recvDetailSeq = recvDetailSeq;
    }

    public RecvHistDetailSearch(RecvHistDetailEntity entity) {
        this.recvSeq = entity.getRecvSeq();
        this.recvDetailSeq = entity.getRecvDetailSeq();
    }

    public RecvHistDetailSearch(RecvHistDetailForm form) {
        this.recvSeq = form.getRecvSeq();
        this.recvDetailSeq = form.getRecvDetailSeq();
    }
}
