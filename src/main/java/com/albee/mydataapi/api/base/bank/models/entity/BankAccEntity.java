package com.albee.mydataapi.api.base.bank.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BankAccEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String seqno;    // 회차번호
    private String isForeignDeposit;    // 외화계좌여부
    private String prodName;    // 상품명
    private String isMinus;    // 마이너스약정 여부
    private String accountType;    // 계좌구분 (코드)
    private String accountStatus;    // 계좌상태 (코드)
}
