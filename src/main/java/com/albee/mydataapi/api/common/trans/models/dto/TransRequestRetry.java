package com.albee.mydataapi.api.common.trans.models.dto;


import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransRequestRetry {
    private String xApiTranId;
    private String type;  // ‘01’ : 전송요구 결과 전송 ‘02’ : 전송요구 철회 결과 전송
    private String txId;  // 트랜잭션 ID(전송요구서 ID). 전송요구-002에서 종합포털이 생성한 트랜잭션 ID(전송요구서 ID)
    private String userCi;
}
