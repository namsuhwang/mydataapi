package com.abcc.mydataapi.api.base.insu.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdCarEntity extends EntityBase {
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
}
