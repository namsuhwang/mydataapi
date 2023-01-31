package com.kpcnc.mydataapi.api.base.dc.models;

import com.kpcnc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class DcHistSearch extends SearchDto {
    private String dcNum;    // 상품관리번호
    private String transDtime;    // 거래일시 또는 거래일자

    public DcHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public DcHistSearch(String memberId, String orgCd, String dcNum) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
    }

    public DcHistSearch(String memberId, String orgCd, String dcNum, String transDtime) {
        super(memberId, orgCd);
        this.dcNum = dcNum;
        this.transDtime = transDtime;
    }

    public DcHistSearch(DcHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.dcNum = entity.getDcNum();
        this.transDtime = entity.getTransDtime();
    }

    public DcHistSearch(DcHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.dcNum = form.getDcNum();
        this.transDtime = form.getTransDtime();
    }
}
