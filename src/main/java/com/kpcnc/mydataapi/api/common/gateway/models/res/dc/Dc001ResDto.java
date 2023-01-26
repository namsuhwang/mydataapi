package com.kpcnc.mydataapi.api.common.gateway.models.res.dc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Dc001ResDto extends ResBaseDto {

    @JsonProperty("dc_cnt")
    private Integer listCnt;

    @JsonProperty("dc_list")
    private List<Dc001ResDetailDto> list;

}
