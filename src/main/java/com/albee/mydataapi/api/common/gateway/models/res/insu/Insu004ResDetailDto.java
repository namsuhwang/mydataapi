package com.albee.mydataapi.api.common.gateway.models.res.insu;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Insu004ResDetailDto {

    private String carNumber;    // 차량번호
    private String carInsuType;    // 자동차보험 구분 (코드)
    private String carName;    // 계약자 차량명
    private String startDate;    // 보험시기
    private String endDate;    // 보험종기
    private String contractAge;    // 연령특약
    private String contractDriver;    // 운전자한정특 약
    private Boolean isOwnDmgCoverage;    // 자기차량손해 (여부)
    private String selfPayRate;    // 자기부담금 구분 (코드)
    private Long selfPayAmt;    // 자기부담금 금액

    public InsuCarForm getForm(FormBase formBase, String insuNum){
        InsuCarForm form = new InsuCarForm();
        form.setMemberId(formBase.getMemberId());
        form.setOrgCd(formBase.getOrgCd());
        form.setInsuNum(insuNum);
        form.setCarNumber(carNumber);
        form.setCarInsuType(carInsuType);
        form.setCarName(carName);
        form.setStartDate(startDate);
        form.setEndDate(endDate);
        form.setContractAge(contractAge);
        form.setContractDriver(contractDriver);
        form.setIsOwnDmgCoverage(isOwnDmgCoverage ? "Y" : "N");
        form.setSelfPayRate(selfPayRate);
        form.setSelfPayAmt(selfPayAmt);
        form.setRegUserId(formBase.getRegUserId());
        form.setRegDt(formBase.getRegDt());
        form.setChgUserId(formBase.getChgUserId());
        form.setChgDt(formBase.getChgDt());
        return form;
    }

}
