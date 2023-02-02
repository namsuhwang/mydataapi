package com.albee.mydataapi.api.base.insu.models.form;

import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdCarForm extends FormBase {
    private String insuNum;    // 증권번호
    private String carNumber;    // 차량번호
    private String carInsuType;    // 자동차보험 구분 (코드)
    private String carName;    // 계약자 차량명
    private String startDate;    // 보험시기
    private String endDate;    // 보험종기
    private String contractAge;    // 연령특약
    private String contractDriver;    // 운전자한정특 약
    private String isOwnDmgCoverage;    // 자기차량손해 (여부)
    private String selfPayRate;    // 자기부담금 구분 (코드)
    private Long selfPayAmt;    // 자기부담금 금액

    public InsuInsdCarEntity getEntity(){
        InsuInsdCarEntity entity = new InsuInsdCarEntity();
        entity.setMemberId(getMemberId());
        entity.setOrgCd(getOrgCd());
        entity.setInsuNum(insuNum);
        entity.setCarNumber(carNumber);
        entity.setCarInsuType(carInsuType);
        entity.setCarName(carName);
        entity.setStartDate(startDate);
        entity.setEndDate(endDate);
        entity.setContractAge(contractAge);
        entity.setContractDriver(contractDriver);
        entity.setIsOwnDmgCoverage(isOwnDmgCoverage);
        entity.setSelfPayRate(selfPayRate);
        entity.setSelfPayAmt(selfPayAmt);
        entity.setApiTranDay(getApiTranDay());
        entity.setApiTranId(getApiTranId());
        entity.setRegUserId(getRegUserId());
        entity.setRegDt(getRegDt());
        entity.setChgUserId(getChgUserId());
        entity.setChgDt(getChgDt());
        return entity;
    }
}
