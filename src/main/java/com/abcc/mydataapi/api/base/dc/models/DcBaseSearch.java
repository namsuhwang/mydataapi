package com.abcc.mydataapi.api.base.dc.models;

import com.abcc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class DcBaseSearch extends SearchDto {
    private String dcNum;    // 상품관리번호

    public DcBaseSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public DcBaseSearch(String memberId, String orgCd, String dcNum) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
    }

    public DcBaseSearch(DcBaseEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.dcNum = entity.getDcNum();
    }

    public DcBaseSearch(DcBaseForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.dcNum = form.getDcNum();
    }
}
