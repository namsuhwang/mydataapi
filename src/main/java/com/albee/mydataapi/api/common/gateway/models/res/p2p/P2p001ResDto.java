package com.albee.mydataapi.api.common.gateway.models.res.p2p;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.albee.mydataapi.api.common.gateway.models.res.ppay.Ppay001ResDetailDto;
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
public class P2p001ResDto extends ResBaseDto {

    @JsonProperty("lending_cnt")
    private Integer listCnt;

    @JsonProperty("lending_list")
    private List<P2p001ResDetailDto> list;

}
