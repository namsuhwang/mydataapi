package com.albee.mydataapi.api.common.gateway.models.res.gurt;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.albee.mydataapi.api.common.gateway.models.res.p2p.P2p001ResDetailDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Gurt001ResDto extends ResBaseDto {

    @JsonProperty("insu_cnt")
    private Integer listCnt;

    @JsonProperty("insu_list")
    private List<Gurt001ResDetailDto> list;

}
