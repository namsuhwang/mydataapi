package com.kpcnc.mydataapi.api.base.invt.models.entity;

import com.kpcnc.mydataapi.api.common.gateway.models.entity.EntityBase;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvtPensionAccAddEntity extends EntityBase {
    private String accountNum;    // 계좌번호
    private String prodType;    // 연금가입일
    private BigDecimal prodTypeDetail;    // 납부총액
    private BigDecimal prodCode;    // 기출금액
    private String exCode;    // 최종납입일
    private BigDecimal prodName;    // 연금기수령액
    private String posType;    // 연금개시(예정)일
    private BigDecimal creditType;    // 금년납입금
    private String isTaxBenefits;    // 통화코드
}
