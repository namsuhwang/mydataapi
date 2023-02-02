package com.abcc.mydataapi.api.base.bank.models.entity;

import com.abcc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankCustEntity extends EntityBase {
    private String regDate;    // 고객생성일
}
