package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdCarForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuInsdCarSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String carInsuType;    // 자동차보험 구분 (코드)

    public InsuInsdCarSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public InsuInsdCarSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuInsdCarSearch(String memberId, String orgCd, String insuNum, String carNumber, String carInsuType) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.carNumber = carNumber;
        this.carInsuType = carInsuType;
    }

    public InsuInsdCarSearch(InsuInsdCarEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.carNumber = entity.getCarNumber();
        this.carInsuType = entity.getCarInsuType();
    }

    public InsuInsdCarSearch(InsuInsdCarForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.carNumber = form.getCarNumber();
        this.carInsuType = form.getCarInsuType();
    }
}
