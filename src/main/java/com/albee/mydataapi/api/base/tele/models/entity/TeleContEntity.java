package com.albee.mydataapi.api.base.tele.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleContEntity extends EntityBase {
    private String mgmtId;    // 계약관리번호
    private String isConsent;    // 전송요구 여부
    private String telecomNum;    // 가입번호
    private String type;    // 통신구분 (코드)
    private String status;    // 가입구분 (코드)
}
