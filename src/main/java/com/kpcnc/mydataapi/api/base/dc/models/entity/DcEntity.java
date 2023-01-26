package com.kpcnc.mydataapi.api.base.dc.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DcEntity extends EntityBase {
    private String dcNum;    // 상품관리번호
    private String dcName;    // 상품명
    private String isConsent;    // 전송요구 여부
}
