package com.kpcnc.mydataapi.api.base.db.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DbEntity extends EntityBase {
    private String isRunningPension;    // 보유여부
}
