package com.albee.mydataapi.common.models.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseDto<D> {
    private String rspCode;
    private String rspMsg;
    private D data;


    public ResponseDto(String rspCode, String rspMsg, D data) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
        this.data = data;
    }

    public ResponseDto(String rspCode, String rspMsg) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }

    public ResponseDto(D data) {
        this.data = data;
    }
}
