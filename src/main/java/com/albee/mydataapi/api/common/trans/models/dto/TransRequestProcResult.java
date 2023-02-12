package com.albee.mydataapi.api.common.trans.models.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
    전송요구-003 입력값
    전송요구-002(전송요구등록/변경) 또는 전송요구-004(전송요구철회) 의 처리 결과를 종합포털에 전송
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransRequestProcResult {
    private String memberId;
    private String xApiTranId;

    private String type; // ‘01’ : 전송요구 결과 전송. ‘02’ : 전송요구 철회 결과 전송

    private String resultCode;  // 전송요구인 경우 : • 성공시 : ‘00000’
                                //               • 실패시 : 통합인증-002 API 에러코드(error)
                                // 전송요구 철회인 경우 : • 개별인증-004 API 응답코드 (rsp_code 또는 error)

    private String resultMsg;   // 전송요구인 경우 :• 성공시 : “성공” 고정값
                                //              • 실패시 : 통합인증-002 API 응답메시지 (error_description)
                                // 전송요구 철회인 경우 : • 개별인증-004 API 응답메시지 (rsp_msg 또는 error_description)

    private String txId;  // 트랜잭션 ID(전송요구서 ID). 전송요구-002에서 종합포털이 생성한 트랜잭션 ID(전송요구서 ID)

    private String userCi;  // ci
}
