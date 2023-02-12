package com.albee.mydataapi.api.base.itfn.models.entity;

import com.albee.mydataapi.common.models.entity.EntityBase;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItfnCustEntity extends EntityBase {
    private String regDate;    // 최초고객DB 생성일
    private String apiTranDay;    // 거래일
    private String apiTranId;    // 거래고유번호
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시
}
