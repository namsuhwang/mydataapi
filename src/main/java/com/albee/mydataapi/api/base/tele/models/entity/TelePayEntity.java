package com.albee.mydataapi.api.base.tele.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TelePayEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String transDate;    // 이용일시
    private Long transAmt;    // 결제금액
    private String orgRegno;    // 가맹점 사업자번호
    private String merchantName;    // 가맹점명
    private String transTitle;    // 결제상품명
}
