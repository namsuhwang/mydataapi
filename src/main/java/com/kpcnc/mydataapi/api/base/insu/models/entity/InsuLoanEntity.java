package com.kpcnc.mydataapi.api.base.insu.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InsuLoanEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String prodName;    // 상품명
    private String isConsent;    // 전송요구 여부
    private String accountType;    // 계좌번호 별 구분 코드
    private String accountStatus;    // 계좌번호 별 상태 코드
}
