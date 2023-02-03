package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.albee.mydataapi.api.common.gateway.models.res.tele.Tele001ResDetailDto;
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
public class Elec001ResDto extends ResBaseDto {

    @JsonProperty("fob_cnt")
    private Integer listCnt;

    @JsonProperty("fob_list")
    private List<Elec001ResDetailDto> list;

}
