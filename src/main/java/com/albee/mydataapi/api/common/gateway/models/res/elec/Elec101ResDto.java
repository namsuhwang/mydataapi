package com.albee.mydataapi.api.common.gateway.models.res.elec;

import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
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
public class Elec101ResDto extends ResBaseDto {

    @JsonProperty("account_cnt")
    private Integer listCnt;

    @JsonProperty("account_list")
    private List<Elec101ResDetailDto> list;

}
