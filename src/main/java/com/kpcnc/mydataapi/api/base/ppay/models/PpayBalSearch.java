package com.kpcnc.mydataapi.api.base.ppay.models;

import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PpayBalSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String ppId;    // 선불카드 식별자

    public PpayBalSearch(String memberId, String orgCd, String ppId) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.ppId = ppId;
    }

    public PpayBalSearch(PpayBalEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.ppId = entity.getPpId();
    }

    public PpayBalSearch(PpayBalForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.ppId = form.getPpId();
    }
}
