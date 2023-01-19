package com.kpcnc.mydataapi.api.common.gateway.models.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InBaseDto {
    @JsonProperty("x-api-tran-id")
    private String xApiTranId;
    private String rspCode;
    private String rspMsg;
    private Long searchTimestamp;
    private String nextPage;
}
