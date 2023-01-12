package com.kpcnc.mydataapi.api.load.insu.models.form;

import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdCarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdCarForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
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
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public InsuInsdCarEntity getEntity(){
        InsuInsdCarEntity entity = new InsuInsdCarEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
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
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
