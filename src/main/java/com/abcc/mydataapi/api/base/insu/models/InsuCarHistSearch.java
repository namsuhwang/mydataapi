package com.abcc.mydataapi.api.base.insu.models;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.abcc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class InsuCarHistSearch extends SearchDto {
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호

    public InsuCarHistSearch(String memberId, String orgCd, String insuNum, String carNumber) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.carNumber = carNumber;
    }


    public InsuCarHistSearch(String memberId, String orgCd, String insuNum, String carNumber, String transDtime, String transNo) {
        super(memberId, orgCd);
        this.insuNum = insuNum;
        this.carNumber = carNumber;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public InsuCarHistSearch(InsuCarHistEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.insuNum = entity.getInsuNum();
        this.carNumber = entity.getCarNumber();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public InsuCarHistSearch(InsuCarHistForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.insuNum = form.getInsuNum();
        this.carNumber = form.getCarNumber();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
