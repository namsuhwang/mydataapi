package com.kpcnc.mydataapi.api.base.insu.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuGurtEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String subject;    // 계약관계자 구분 (코드)
    private String relation;    // 피보험자계약 자관계 (코드)
    private String status;    // 담보상태 (코드)
    private String coverageCode;    // 담보 (코드)
    private Integer type;    // 담보특성 (코드)
    private String coverageNum;    // 회사담보일렬 번호
    private String coverageName;    // 회사담보명
    private Long coverageAmt;    // 담보금액
    private String startDate;    // 담보기간 시작일자
    private String endDate;    // 담보기간 종료일자
}
