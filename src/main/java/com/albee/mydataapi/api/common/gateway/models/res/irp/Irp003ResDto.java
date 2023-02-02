package com.albee.mydataapi.api.common.gateway.models.res.irp;

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
public class Irp003ResDto extends ResBaseDto {

    @JsonProperty("irp_cnt")
    private Integer listCnt;

    @JsonProperty("irp_list")
    private List<Irp003ResDetailDto> list;

}
