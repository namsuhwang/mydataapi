package com.kpcnc.mydataapi.api.common.gateway.models.res.ppay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.irp.Irp001ResDetailDto;
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
public class Ppay001ResDto extends ResBaseDto {

    @JsonProperty("pp_cnt")
    private Integer listCnt;

    @JsonProperty("pp_list")
    private List<Ppay001ResDetailDto> list;

}
