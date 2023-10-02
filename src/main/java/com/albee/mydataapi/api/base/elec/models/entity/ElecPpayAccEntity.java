package com.albee.mydataapi.api.base.elec.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElecPpayAccEntity extends EntityBase {
    private String fobId;    // 권면 ID
    private String accountId;    // 계정식별값
}
