package com.kpcnc.mydataapi.api.base.dc.models;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class DcBaseSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String dcNum;    // 상품관리번호

    public DcBaseSearch(String memberId, String orgCd, String dcNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.dcNum = dcNum;
    }

    public DcBaseSearch(DcBaseEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.dcNum = entity.getDcNum();
    }

    public DcBaseSearch(DcBaseForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.dcNum = form.getDcNum();
    }
}
