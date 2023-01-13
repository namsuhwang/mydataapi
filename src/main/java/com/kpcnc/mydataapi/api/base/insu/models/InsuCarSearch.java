package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuCarSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String carInsuType;    // 자동차보험 구분 (코드)

    public InsuCarSearch(String memberId, String orgCd, String insuNum, String carNumber, String carInsuType) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.carNumber = carNumber;
        this.carInsuType = carInsuType;
    }

    public InsuCarSearch(InsuCarEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.carNumber = entity.getCarNumber();
        this.carInsuType = entity.getCarInsuType();
    }

    public InsuCarSearch(InsuCarForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.carNumber = form.getCarNumber();
        this.carInsuType = form.getCarInsuType();
    }
}
