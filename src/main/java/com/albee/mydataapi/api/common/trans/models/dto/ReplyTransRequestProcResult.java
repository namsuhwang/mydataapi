package com.albee.mydataapi.api.common.trans.models.dto;


import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
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
public class ReplyTransRequestProcResult {
    private String memberId;
    private String xApiTranId;
    private String type;
    private String resultCode;
    private String resultMsg;
    private String txId;
    private String userCi;
}
