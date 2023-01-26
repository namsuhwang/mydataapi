package com.kpcnc.mydataapi.api.common.gateway.models.res.dc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.irp.Irp004ResDetailDto;
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
public class Dc004ResDto extends ResBaseDto {

    @JsonProperty("dc_cnt")
    private Integer listCnt;

    @JsonProperty("dc_list")
    private List<Dc004ResDetailDto> list;

}
