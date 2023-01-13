package com.kpcnc.mydataapi.api.base.dc.models;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class DcSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String dcNum;    // 상품관리번호

    public DcSearch(String memberId, String orgCd, String dcNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.dcNum = dcNum;
    }

    public DcSearch(DcEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.dcNum = entity.getDcNum();
    }

    public DcSearch(DcForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.dcNum = form.getDcNum();
    }
}
