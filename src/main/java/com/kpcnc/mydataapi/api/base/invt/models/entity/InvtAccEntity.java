package com.kpcnc.mydataapi.api.base.invt.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtAccEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String isConsent;    // 전송요구 여부
    private String accountName;    // 계좌명
    private String accountType;    // 계좌종류(코드)
    private String issueDate;    // 계좌개설일
    private String isTaxBenefits;    // 세제혜택 적용여부(계좌)
    private String isCma;    // CMA상품포함 여부
    private String isStockTrans;    // 주식거래가능 여부
    private String isAccountLink;    // 은행예수금 방식계좌여부
}
