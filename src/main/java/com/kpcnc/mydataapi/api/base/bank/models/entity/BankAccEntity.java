package com.kpcnc.mydataapi.api.base.bank.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
