package com.kpcnc.mydataapi.api.common.recv.models;

import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class RecvHistDetailSearch extends SearchDto {
    private String recvId;    // 수신 ID
    private Long recvSeq;    // 수신 일련번호

    public RecvHistDetailSearch(String recvId, Long recvSeq) {
        this.recvId = recvId;
        this.recvSeq = recvSeq;
    }

    public RecvHistDetailSearch(RecvHistDetailEntity entity) {
        this.recvId = entity.getRecvId();
        this.recvSeq = entity.getRecvSeq();
    }

    public RecvHistDetailSearch(RecvHistDetailForm form) {
        this.recvId = form.getRecvId();
        this.recvSeq = form.getRecvSeq();
    }
}
