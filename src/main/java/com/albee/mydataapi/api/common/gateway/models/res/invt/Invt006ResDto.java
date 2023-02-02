package com.albee.mydataapi.api.common.gateway.models.res.invt;

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
public class Invt006ResDto extends ResBaseDto {

    @JsonProperty("scheduled_cnt")
    private Integer listCnt;

    @JsonProperty("scheduled_list")
    private List<Invt006ResDetailDto> list;
}
