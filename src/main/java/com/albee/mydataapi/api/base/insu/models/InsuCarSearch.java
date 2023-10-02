package com.albee.mydataapi.api.base.insu.models;

import com.albee.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InsuCarSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String carInsuType;    // 자동차보험 구분 (코드)

    public InsuCarSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }


    public InsuCarSearch(String memberId, String orgCd, String insuNum) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
    }

    public InsuCarSearch(String memberId, String orgCd, String insuNum, String carNumber, String carInsuType) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.carNumber = carNumber;
        this.carInsuType = carInsuType;
    }

    public InsuCarSearch(InsuCarEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.carNumber = entity.getCarNumber();
        this.carInsuType = entity.getCarInsuType();
    }

    public InsuCarSearch(InsuCarForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.carNumber = form.getCarNumber();
        this.carInsuType = form.getCarInsuType();
    }
}
