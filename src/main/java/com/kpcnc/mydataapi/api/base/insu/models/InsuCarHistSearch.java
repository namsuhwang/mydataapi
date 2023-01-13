package com.kpcnc.mydataapi.api.base.insu.models;

import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class InsuCarHistSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String transDtime;    // 거래일시 또는 거래일자
    private String transNo;    // 거래번호

    public InsuCarHistSearch(String memberId, String orgCd, String insuNum, String carNumber, String transDtime, String transNo) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.insuNum = insuNum;
        this.carNumber = carNumber;
        this.transDtime = transDtime;
        this.transNo = transNo;
    }

    public InsuCarHistSearch(InsuCarHistEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.insuNum = entity.getInsuNum();
        this.carNumber = entity.getCarNumber();
        this.transDtime = entity.getTransDtime();
        this.transNo = entity.getTransNo();
    }

    public InsuCarHistSearch(InsuCarHistForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.insuNum = form.getInsuNum();
        this.carNumber = form.getCarNumber();
        this.transDtime = form.getTransDtime();
        this.transNo = form.getTransNo();
    }
}
