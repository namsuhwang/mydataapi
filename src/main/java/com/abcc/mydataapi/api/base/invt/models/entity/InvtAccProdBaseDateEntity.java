package com.abcc.mydataapi.api.base.invt.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccProdBaseDateEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String baseDate;    // 기준일자
}
