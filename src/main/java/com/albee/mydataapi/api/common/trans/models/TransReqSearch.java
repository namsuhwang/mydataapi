package com.albee.mydataapi.api.common.trans.models;

import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TransReqSearch extends SearchDto {
    private String txId;    // 트랜잭션 ID(전송요구서 ID)

    public TransReqSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public TransReqSearch(String memberId, String orgCd, String txId) {
        super(memberId, orgCd);
        this.txId = txId;
    }

    public TransReqSearch(TransReqEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.txId = entity.getTxId();
    }

    public TransReqSearch(TransReqForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.txId = form.getTxId();
    }
}
