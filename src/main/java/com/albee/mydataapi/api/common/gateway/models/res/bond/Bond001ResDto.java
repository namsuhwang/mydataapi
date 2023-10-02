package com.albee.mydataapi.api.common.gateway.models.res.bond;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Bond001ResDto extends ResBaseDto {

    @JsonProperty("bond_cnt")
    private Integer listCnt;

    @JsonProperty("bond_list")
    private List<Bond001ResDetailDto> list;

}
