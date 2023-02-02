package com.abcc.mydataapi.api.base.insu.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuInsdMiBasePpEntity extends EntityBase {
    private String insuNum;    // 증권번호
    private String prizeNum;    // 피보험인/물 번호
    private String isPerson;    // 인/물 구분코드
    private String prizeName;    // 피보험인/물 명
    private String isPrimary;    // 주피보험자 여부
    private String prizeAddr;    // 소재지
    private String objectCode;    // 물건구분 (코드)
    private String prizeCode;    // 목적물(코드)
}
