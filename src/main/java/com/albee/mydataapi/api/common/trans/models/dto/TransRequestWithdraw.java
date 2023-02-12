package com.albee.mydataapi.api.common.trans.models.dto;

 
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
    전송요구-004 입력값(전송요구 철회)
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransRequestWithdraw {
    private String memberId;
    private String xApiTranId;

    private String txId;  // 트랜잭션 ID(전송요구서 ID). 전송요구-002에서 종합포털이 생성한 트랜잭션 ID(전송요구서 ID)

    private String userCi;  // ci

    private Boolean isDelete;   // 개인신용정보 삭제여부. 정보수신자가 수집한 정보주체의 개인신용정보를 즉시 삭제해야 하는지 여부
}
