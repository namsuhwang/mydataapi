package com.kpcnc.mydataapi.api.base.dc.models;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcAddForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class DcAddSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String dcNum;    // 상품관리번호
    private String prodName;    // 개별운용상품명

    public DcAddSearch(String memberId, String orgCd, String dcNum, String prodName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.dcNum = dcNum;
        this.prodName = prodName;
    }

    public DcAddSearch(DcAddEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.dcNum = entity.getDcNum();
        this.prodName = entity.getProdName();
    }

    public DcAddSearch(DcAddForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.dcNum = form.getDcNum();
        this.prodName = form.getProdName();
    }
}
