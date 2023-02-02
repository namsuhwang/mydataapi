package com.albee.mydataapi.api.base.bank.models.entity;

import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BankCustEntity extends EntityBase {
    private String regDate;    // 고객생성일
}
