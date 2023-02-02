package com.abcc.mydataapi.api.common.gateway.models.res.itfn;

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
public class Itfn001ResDto extends ResBaseDto {

    private String regDate;

    @JsonProperty("account_cnt")
    private Integer listCnt;

    @JsonProperty("account_list")
    private List<Itfn001ResDetailDto> list;

}
