package com.kpcnc.mydataapi.api.base.gurt.models;

import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtInsdForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GurtInsdSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String insuredName;    // 피보험자명

    public GurtInsdSearch(String memberId, String orgCd, String insuNum, String insuredName) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.insuredName = insuredName;
    }

    public GurtInsdSearch(GurtInsdEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.insuredName = entity.getInsuredName();
    }

    public GurtInsdSearch(GurtInsdForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.insuredName = form.getInsuredName();
    }
}