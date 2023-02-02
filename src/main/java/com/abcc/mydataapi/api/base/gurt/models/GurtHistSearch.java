package com.abcc.mydataapi.api.base.gurt.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtHistForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GurtHistSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자

    public GurtHistSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public GurtHistSearch(String memberId, String orgCd, String insuNum, Integer paidInCnt, String transDate) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.paidInCnt = paidInCnt;
        this.transDate = transDate;
    }

    public GurtHistSearch(GurtHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.paidInCnt = entity.getPaidInCnt();
        this.transDate = entity.getTransDate();
    }

    public GurtHistSearch(GurtHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.paidInCnt = form.getPaidInCnt();
        this.transDate = form.getTransDate();
    }
}
