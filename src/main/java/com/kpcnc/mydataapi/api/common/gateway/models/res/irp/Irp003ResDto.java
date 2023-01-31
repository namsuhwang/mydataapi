package com.kpcnc.mydataapi.api.common.gateway.models.res.irp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Irp003ResDto extends ResBaseDto {

    @JsonProperty("irp_cnt")
    private Integer listCnt;

    @JsonProperty("irp_list")
    private List<Irp003ResDetailDto> list;

}