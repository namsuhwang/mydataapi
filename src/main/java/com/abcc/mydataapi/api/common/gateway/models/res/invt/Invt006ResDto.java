package com.abcc.mydataapi.api.common.gateway.models.res.invt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.abcc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Invt006ResDto extends ResBaseDto {

    @JsonProperty("scheduled_cnt")
    private Integer listCnt;

    @JsonProperty("scheduled_list")
    private List<Invt006ResDetailDto> list;
}
