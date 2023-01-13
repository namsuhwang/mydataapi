package com.kpcnc.mydataapi.api.base.gurt.models;

import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GurtSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호

    public GurtSearch(String memberId, String orgCd, String insuNum) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
    }

    public GurtSearch(GurtEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
    }

    public GurtSearch(GurtForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
    }
}
