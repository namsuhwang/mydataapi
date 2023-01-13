package com.kpcnc.mydataapi.api.base.elec.models;

import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ElecPpayHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호
    private String transType;    // 거래유형(코드)

    public ElecPpayHistSearch(String memberId, String orgCd, String fobId, String accountId, String transDtime, String transNo, String transType) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.fobId = fobId;
        this.accountId = accountId;
        this.transDtime = transDtime;
        this.transNo = transNo;
        this.transType = transType;
    }

    public ElecPpayHistSearch(ElecPpayHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.fobId = entity.getFobId();
        this.accountId = entity.getAccountId();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
        this.transType = entity.getTransType();
    }

    public ElecPpayHistSearch(ElecPpayHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.fobId = form.getFobId();
        this.accountId = form.getAccountId();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
        this.transType = form.getTransType();
    }
}
