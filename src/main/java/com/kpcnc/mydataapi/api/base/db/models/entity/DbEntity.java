package com.kpcnc.mydataapi.api.base.db.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DbEntity extends EntityBase {
    private String isRunningPension;    // 보유여부
}
