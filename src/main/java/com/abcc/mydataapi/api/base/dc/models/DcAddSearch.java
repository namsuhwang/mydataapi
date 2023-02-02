package com.abcc.mydataapi.api.base.dc.models;

import com.abcc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcAddForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class DcAddSearch extends SearchDto {
    private String dcNum;    // 상품관리번호
    private String prodName;    // 개별운용상품명

    public DcAddSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public DcAddSearch(String memberId, String orgCd, String dcNum) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
    }

    public DcAddSearch(String memberId, String orgCd, String dcNum, String prodName) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
        this.prodName = prodName;
    }

    public DcAddSearch(DcAddEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.dcNum = entity.getDcNum();
        this.prodName = entity.getProdName();
    }

    public DcAddSearch(DcAddForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.dcNum = form.getDcNum();
        this.prodName = form.getProdName();
    }
}
