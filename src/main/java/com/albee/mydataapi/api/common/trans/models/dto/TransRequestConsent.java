package com.albee.mydataapi.api.common.trans.models.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransRequestConsent {
    private String sndOrgCode; // "O100000001"
    private String rcvOrgCode;  // "A100000001"
    private Boolean isScheduled;  // "true"
    private String fndCycle;   // "1/w"
    private String addCycle;   // "1/w"
    private String endDate;  // "20220804"
    private String purpose;   // "상세정보 전송요구를 위한 가입상품목록 조회"
    private String period;  // "20220804"
    private Boolean isConsentTransMemo;   // "true"
    private List<TransTargetInfo> targetInfo;
}
