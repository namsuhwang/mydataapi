package com.albee.mydataapi.api.base.dc.models;

import com.albee.mydataapi.api.base.dc.models.entity.DcEntity;
import com.albee.mydataapi.api.base.dc.models.form.DcForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class DcSearch extends SearchDto {
    private String dcNum;    // 상품관리번호

    public DcSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public DcSearch(String memberId, String orgCd, String dcNum) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
    }

    public DcSearch(DcEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.dcNum = entity.getDcNum();
    }

    public DcSearch(DcForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.dcNum = form.getDcNum();
    }
}
