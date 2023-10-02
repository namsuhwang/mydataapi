package com.albee.mydataapi.api.base.tele.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleHistEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String transMonth;    // 납부연월
    private Long paidAmt;    // 납부금액
    private String payMethod;    // 납부수단(코드)
}
