package com.kpcnc.mydataapi.api.load.gurt.models;

import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtHistEntity;
import com.kpcnc.mydataapi.api.load.gurt.models.form.GurtHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GurtHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private Integer paidInCnt;    // 납입회차
    private String transDate;    // 납입일자

    public GurtHistSearch(String memberId, String orgCd, String insuNum, Integer paidInCnt, String transDate) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.paidInCnt = paidInCnt;
        this.transDate = transDate;
    }

    public GurtHistSearch(GurtHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.paidInCnt = entity.getPaidInCnt();
        this.transDate = entity.getTransDate();
    }

    public GurtHistSearch(GurtHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.paidInCnt = form.getPaidInCnt();
        this.transDate = form.getTransDate();
    }
}
