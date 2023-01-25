package com.kpcnc.mydataapi.api.common.gateway.models.res;

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
public class Bank002ResDto extends ResBaseDto {
    @JsonProperty("basic_cnt")
    private Integer listCnt;

    @JsonProperty("basic_list")
    private List<Bank002ResDetailDto> list;

}