package com.albee.mydataapi.api.common.trans.models.dto;


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
public class TransRequestRevokeRequest {
    private String memberId;
    private String xApiTranId;
    private String txId;
    private String userCi;
    private Boolean isDelete;   // 정보수신자가 수집한 정보주체의 개인신용정보를 즉시 삭제해야 하는지 여부
}
